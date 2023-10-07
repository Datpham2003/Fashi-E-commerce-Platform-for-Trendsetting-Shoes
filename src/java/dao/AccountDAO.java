/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.product;

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
    
//       public static void main(String[] args) {
//        AccountDAO dao = new AccountDAO();
//        int a = dao.getCustomerIDByAccountID(4);
//           System.out.println(a);
//        }
    }

