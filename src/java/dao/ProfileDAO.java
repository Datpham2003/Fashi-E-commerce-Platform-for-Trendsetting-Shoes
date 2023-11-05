/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.account;
import model.profile;

/**
 *
 * @author acer
 */
public class ProfileDAO extends DBContext{
    
    public  profile getProfile(int profile_id){
            
        try{
            String sql = "select * from Profile where profile_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, profile_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               return new profile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
    public void setIdProfile(int profile_id){
        
        String sql = "INSERT INTO Profile\n" +
                        "(profile_id)\n" +
                     "VALUES\n" +
                        "(?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, profile_id);
            ps.executeUpdate();
        }catch (Exception ex){
            
        }
    }
    
     public int getProfileByAccountID(int account_id){
        int profile_id = -1;
        String sql = "select profile_id from Account where account_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            try ( ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    profile_id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile_id;
    }
     
    public List<profile> listAllProfile(int account_id){
    
        List<profile> listProfile = new ArrayList<>();
         String sql = "select * from Profile where profile_id=?";
         try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            try ( ResultSet rs = ps.executeQuery()) {
                
                while (rs.next()) {
                      listProfile.add(new profile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProfile;
    }
//    public void insertProfile(int profile_id, String full_name,String phone,String dob,int gender, String address,String email){
//        String sql = "INSERT INTO Profile\n" +
//                        "(profile_id, full_name, phone, dob, gender, address, email)\n" +
//                     "VALUES\n" +
//                        "('?', '?', '?', '?', '?', '?', '?')";
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, profile_id);
//            ps.setString(2, full_name);
//            ps.setString(3, phone);
//            ps.setString(4, dob);
//            ps.setInt(5, gender);
//            ps.setString(6, address);
//            ps.setString(7, email);
//            ps.executeUpdate();
//        }catch (Exception ex){
//            
//        }
//               
//    }
    
    public void insertProfile(int profile_id, String full_name, String phone, String dob, int gender, String address, String email) {
    String sql = "INSERT INTO Profile (profile_id, full_name, phone, dob, gender, address, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, profile_id);
        ps.setString(2, full_name);
        ps.setString(3, phone);
        ps.setString(4, dob);
        ps.setInt(5, gender);
        ps.setString(6, address);
        ps.setString(7, email);
        ps.executeUpdate();
    } catch (SQLException ex) {
        // Xử lý lỗi, in ra thông báo lỗi hoặc ghi log lỗi
        ex.printStackTrace();
    }
}

    
    public profile checkProfileID (int profile_id){
        try {
            String sql = "select * from Profile where profile_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, profile_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return new profile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
            }
        } catch (SQLException ex) {   
        }
        return null;
    }
    
    public void updateProfile(String full_name, String phone, String dob, int gender, String address, String email, int profile_id) {
        String sql = "UPDATE Profile " +
                     "SET full_name=?, phone=?, dob=?, gender=?, address=?, email=? " +
                     "WHERE profile_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, full_name);
            ps.setString(2, phone);
            ps.setString(3, dob);
            ps.setInt(4, gender);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.setInt(7, profile_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
        
            ex.printStackTrace();
        }
    }
    
    public void updateImage(String image, int profile_id) {
        String sql = "UPDATE Profile " +
                     "SET image= ? " +
                     "WHERE profile_id= ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, image);
            ps.setInt(2, profile_id);
            ps.executeUpdate();
        } catch (SQLException ex) {       
            ex.printStackTrace();
        }
    }


    
     
    public static void main(String[] args) {
          ProfileDAO dao = new ProfileDAO();     
          dao.updateImage("", 4);
    }
}
