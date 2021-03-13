/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynhntp.controller;

import huynhntp.dao.UserDAO;
import huynhntp.dto.UserDTO;
import huynhntp.util.SendMail;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class RegisterController extends HttpServlet {

   private final String ERROR = "index.html";
    private final String SUCCESS = "registerStatus.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        try {
            String userName = request.getParameter("userName");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String addr = request.getParameter("addr");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirmPass");
            if(!password.equals(confirm)){
                check = false;
                request.setAttribute("STATUS", "Confirm password not correct");
            }
            if(phone.trim().isEmpty() || addr.trim().isEmpty()){
                check = false;
                request.setAttribute("STATUS", "Please fill out all the information in the boxes ");
            }
             
            
            if(check){
                UserDAO dao = new UserDAO();
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                UserDTO dto = new UserDTO(userName, email, password, name, phone, addr, false , "US", fm.format(date));
                dao.register(dto);
                request.setAttribute("STATUS", "Register success! Please check your email to verify!");
                SendMail.send("TIle", "OKE", email);
            }
            url = SUCCESS;
            
        } catch (SQLException e) {
            if(e.toString().contains("duplicate")){
                request.setAttribute("STATUS", "Email has been existed!");
            }
            log(e.toString());
            url = SUCCESS;
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
