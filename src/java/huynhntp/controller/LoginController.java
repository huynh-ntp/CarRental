/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynhntp.controller;

import huynhntp.common.VerifyRecaptcha;
import huynhntp.dao.UserDAO;
import huynhntp.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
public class LoginController extends HttpServlet {
    
    
    private final String ERROR = "index.html";
    private final String SUCCESS = "home.jsp";
    private final String FAILED = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        try {
            String email = request.getParameter("userName");
            String password = request.getParameter("password");
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkLogin(email, password);
            if(user==null){
                check = false;
                request.setAttribute("ERROR", "Incorrect userName or password");
                url = FAILED;
            }
            boolean verrifyCapcha = VerifyRecaptcha.verify(gRecaptchaResponse);
            if(!verrifyCapcha){
                check = false;
                request.setAttribute("ERROR", "Missing verify recaptcha");
                 url = FAILED;
            }
            
            if(check && user!=null){
                HttpSession session = request.getSession();
                if(user.getRoleID().equals("US")){
                    url = SUCCESS;
                    session.setAttribute("USER", user);
                }
            }
            
        } catch (IOException e) {
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
