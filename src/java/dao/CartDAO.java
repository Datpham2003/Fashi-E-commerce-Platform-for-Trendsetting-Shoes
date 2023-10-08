/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.cart;

/**
 *
 * @author quang
 */
public class CartDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public cart checkCartExist(int customer_id, int product_id) {

        String sql = "select * from Shopping_Cart\r\n"
                + "where [customer_id] = ? and [product_id] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, customer_id);
            ps.setInt(2, product_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editAmountAndSizeCart(int product_id, int product_quantity, int customer_id, String product_Size) {
        String query = "update Shopping_Cart set [product_quantity]=?,\r\n"
                + "[product_Size]=?\r\n"
                + "where [customer_id]=? and [product_id]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_id);
            ps.setInt(2, product_quantity);
            ps.setInt(3, customer_id);
            ps.setString(4, product_Size);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCart(int product_id, int product_quantity, int customer_id, String product_Size) {
        String query = "insert Cart(accountID, productID, amount,size)\r\n"
                + "values(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_id);
            ps.setInt(2, product_quantity);
            ps.setInt(3, customer_id);
            ps.setString(4, product_Size);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
        

    public List<cart> getCartByCustomerID(int customer_id) {
        List<cart> list = new ArrayList<>();
        String query = "select * from Shopping_Cart where customer_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, customer_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }


//    public static void main(String[] args) {
//        CartDAO dao = new CartDAO();
//        cart c = dao.checkCartExist(1, 1);
//        System.out.println(c);
//    }
}
