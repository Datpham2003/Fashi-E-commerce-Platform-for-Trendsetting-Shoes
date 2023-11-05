package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.account;

/**
 *
 * @author acer
 */
public class LoginDAO extends DBContext {

    public account checkLogin(String username, String password){
  
        try {
            String sql = "select *from Account where username=? and password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public account checkAccount(String username){
  
        try {
            String sql = "select *from Account where username= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return new account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {   
        }
        return null;
    }
    
    public void signUp(String username, String password){
        String sql = "insert into Account (username , password)\n "
                + "values(?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        }catch (Exception ex){
            
        }
    }
    
    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
        ProfileDAO p = new ProfileDAO();
        int i = a.getProfileIDByUsername("test");
        System.out.println(i);
        p.setIdProfile(i);
        
    }
}
