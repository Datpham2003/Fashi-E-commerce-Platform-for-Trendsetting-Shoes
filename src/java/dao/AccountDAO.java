/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.account;
import model.product;
import model.profile;

/**
 *
 * @author quang
 */
public class AccountDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int getAccountIDByUsername(String username) {
        int account_id = -1;
        String sql = "select account_id from Account where username = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            try ( ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    account_id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account_id;
    }
    
    public int getCustomerIDByAccountID(int account_id) {
        int customer_id = -1;
        String sql = "select customer_id from Customer where account_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            try ( ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    customer_id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer_id;
    }
    
    public List<profile> getAllProfileByAccount() {
        List<profile> list = new ArrayList<>();
        String sql = "select ac.account_id, pro.profile_id, r.role_id ,pro.full_name, pro.image, "
                + "pro.phone, pro.gender, pro.dob, pro.address, pro.email, r.role_name from Account ac\n"
                + "JOIN Profile pro ON pro.profile_id = ac.profile_id\n"
                + "JOIN Role r ON r.role_id = ac.role_id";
//        int account_id, role_id, profile_id, gender;
//        String full_name, image, phone, address, email, role_name;
//        Date dob;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                profile pro = new profile();
                pro.setProfile_id(rs.getInt("profile_id"));
                pro.setFull_name(rs.getString("full_name"));
                pro.setImage(rs.getString("image"));
                pro.setPhone(rs.getString("phone"));
                pro.setGender(rs.getInt("gender"));
                pro.setDob(rs.getString("dob"));
                pro.setAddress(rs.getString("address"));
                pro.setEmail(rs.getString("email"));
                Role r = new Role();
                r.setRole_id(rs.getInt("role_id"));
                r.setRole_name(rs.getString("role_name"));
                account ac = new account();
                ac.setIdAccount(rs.getInt("account_id"));
                pro.setRole(r);
                pro.setAccount(ac);
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return list;
    }

    public List<Role> getListRole() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from Role";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteProfileById(int id) {
        String sql = "DELETE FROM Profile WHERE profile_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void updateProfileById(int id) {
//        String sql = "UPDATE pro\n"
//                + "SET  pro.full_name = ?,\n"
//                + "     pro.image = ?,\n"
//                + "     pro.phone = ?,\n"
//                + "     pro.dob = ?,\n"
//                + "     pro.gender = ?,\n"
//                + "     pro.email = ?\n"
//                + "FROM Profile pro\n"
//                + "INNER JOIN Account ac ON ac.profile_id = pro.profile_id\n"
//                + "INNER JOIN Role r ON r.role_id = ac.role_id\n"
//                + "WHERE pro.profile_id = ?";
//        try{
//            ps = conn.prepareStatement(sql);
//
//            ps.setString(1, fullName);
//            ps.setString(2, image);
//            ps.setString(3, phone);
//            ps.setString(4, dob);
//            ps.setString(5, gender);
//            ps.setString(6, email);
//            ps.setInt(7, profileId);
//
//            ps.executeUpdate();
//            ps.close();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public void addNewProfile(int profile_id, String full_name, String image, String phone, int gender, Date dob, String address, String email) {
        String sql = "INSERT INTO Profile (profile_id, full_name, image, phone, gender, dob, address, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, profile_id);
            ps.setString(2, full_name);
            ps.setString(3, image);
            ps.setString(4, phone);
            ps.setInt(5, gender);
            ps.setDate(6, new java.sql.Date(dob.getTime()));
            ps.setString(7, address);
            ps.setString(8, email);
            ps.executeUpdate();
            // Handle generated keys if necessary
        } catch (Exception e) {
            // Handle the specific SQL exception here

        }
        // Handle other exceptions here

    }

    public void addNewAccount(int role_id, String username, String password) {
        String sql = "INSERT INTO Account (role_id, username, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, role_id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
        } catch (Exception e) {
            // Handle the specific SQL exception here        
        }
        // Handle other exceptions here

    }

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        String sql = "SELECT * FROM Role";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Role getRoleById(int role_id) {
        String sql = "SELECT * FROM Role Where role_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, role_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Role(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public profile getProfileById(int id) {
        String sql = "select * from Profile where profile_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new profile(rs.getInt(1),
                        rs.getString(3),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public account getAccountById(int account_id) {
        String sql = "select * from Account where account_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRoleByID(String roleName, int roleId) {
        String updateRoleSql = "UPDATE Role SET role_name = ? WHERE role_id = ?";
        try {
            PreparedStatement updateRolePs = connection.prepareStatement(updateRoleSql);
            updateRolePs.setString(1, roleName);
            updateRolePs.setInt(2, roleId);
            updateRolePs.executeUpdate();
            updateRolePs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoleByProfileIDInAcc(int profile_id, int role_id) {
        String updateRoleSql = "UPDATE Account SET role_id = ? WHERE profile_id = ?";
        try {
            PreparedStatement updateRolePs = connection.prepareStatement(updateRoleSql);
            updateRolePs.setInt(1, role_id);
            updateRolePs.setInt(2, profile_id);
            updateRolePs.executeUpdate();
            updateRolePs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoleByProfileIDInPr(int profile_id, int role_id) {
        String updateRoleSql = "UPDATE Profile SET role_id = ? WHERE profile_id = ?";
        try {
            PreparedStatement updateRolePs = connection.prepareStatement(updateRoleSql);
            updateRolePs.setInt(1, role_id);
            updateRolePs.setInt(2, profile_id);
            updateRolePs.executeUpdate();
            updateRolePs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProfile(String full_name, String image, String phone, int gender, String dob, String address, String email, int profile_id) {
        String updateProfileSql = "UPDATE Profile SET full_name = ?, image = ?, phone = ?, gender = ?, dob = ?, address = ?, email = ? WHERE profile_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(updateProfileSql);
            ps.setString(1, full_name);
            ps.setString(2, image);
            ps.setString(3, phone);
            ps.setInt(4, gender);
            ps.setString(5, dob);
            ps.setString(6, address);
            ps.setString(7, email);
            ps.setInt(8, profile_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(int profile_id, int role_id, String username, String password) {
        String updateAccountSql = "UPDATE Account SET  username = ?, password = ?, role_id =?  WHERE account_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(updateAccountSql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, role_id);
            ps.setInt(4, profile_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int AddNewProfile(String fullName, String image, String phone, String dob, int gender, String address, String email) {
        String sql = "INSERT INTO Profile(full_name, image, phone, dob, gender, address, email) VALUES (?, ?, ?, ?, ?, ?, ?";

        try ( PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, fullName);
            ps.setString(2, image);
            ps.setString(3, phone);
            ps.setString(4, dob);
            ps.setInt(5, gender);
            ps.setString(6, address);
            ps.setString(7, email);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 1) {
                // Lấy ID của bản ghi vừa được thêm vào
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Trả về giá trị mặc định (ví dụ: -1) nếu không thành công
        return -1;
    }

    public int getProfileIDByUsername(String username) {
        int profile_id = -1;
        String sql = "select profile_id from Account where username = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
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
        } catch (Exception ex) {
            // Xử lý lỗi, in ra thông báo lỗi hoặc ghi log lỗi
            ex.printStackTrace();
        }
    }
    
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        boolean passwordChanged = false;
        String sql = "UPDATE Account SET password = ? WHERE username = ? AND password = ?";

        try { 
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.setString(3, oldPassword);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                passwordChanged = true;
            }
        } catch (Exception e) {
            // Xử lý exception tại đây
            e.printStackTrace();
        } 
        return passwordChanged;
    }

      
    }

