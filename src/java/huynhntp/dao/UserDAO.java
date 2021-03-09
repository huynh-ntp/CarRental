/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynhntp.dao;

import huynhntp.dto.UserDTO;
import huynhntp.util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author ACER
 */
public class UserDAO {
    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    public UserDTO checkLogin(String email, String password) throws SQLException{
        UserDTO dto = null;
        try {
            conn = DBConnect.makeConnection();
            if(conn!=null){
                String sql = "SELECT email,name,status,roleID"
                        + " FROM tblUsers "
                        + "WHERE email = ? and password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    dto = new UserDTO(rs.getString("email"), rs.getString("name"), rs.getBoolean("status"), rs.getString("roleID"));
                }
                
            }
        } catch (SQLException | NamingException e) {
        }finally{
            closeConnect();
        }
        return dto;
    }
    
    
    public void verifyEmail(String email) throws SQLException{
        try {
            conn = DBConnect.makeConnection();
            if(conn!=null){
                String sql = "UPDATE tblUsers"
                        + " SET status = 1"
                        + " WHERE email = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                stm.executeQuery();
            }
        } catch (SQLException | NamingException e) {
        }finally{
            closeConnect();
        }
    }
    
    
    
    private void closeConnect() throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if(stm!=null){
            stm.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
}
