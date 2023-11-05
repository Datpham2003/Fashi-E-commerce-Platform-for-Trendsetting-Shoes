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

    public cart checkCartExist(int customer_id, int product_id, String product_size) {

        String sql = "select * from Shopping_Cart\r\n"
                + "where [customer_id] = ? and [product_id] = ? and [product_size] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, customer_id);
            ps.setInt(2, product_id);
            ps.setString(3, product_size);
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

    public void editAmountAndSizeCart(int product_id, int product_quantity, int customer_id, String product_size) {
        String query = "update Shopping_Cart set [product_quantity]= ? "
                + "where [customer_id]= ? and [product_id]= ? and [product_size] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_quantity);
            ps.setInt(2, customer_id);
            ps.setInt(3, product_id);
            ps.setString(4, product_size);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCart(int product_id, int product_quantity, int customer_id, String product_size) {
        String query = "insert Shopping_Cart(product_id, product_quantity, customer_id,product_size)\r\n"
                + "values(?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_id);
            ps.setInt(2, product_quantity);
            ps.setInt(3, customer_id);
            ps.setString(4, product_size);
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

    public void deleteCart(int product_id, int customer_id, String product_size) {
        String query = "delete from Shopping_Cart where product_id = ? "
                + "and customer_id = ? "
                + "and product_size = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, product_id);
            ps.setInt(2, customer_id);
            ps.setString(3, product_size);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCartByCustomerID(int customer_id) {
        String query = "delete from Shopping_Cart where customer_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertContact(String name, String email, String mess, int accountID) {
        String query = "insert Contact(Name, Email, Content, accountID) values(?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, mess);
            ps.setInt(4, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CartDAO dao = new CartDAO();
       dao.insertContact("trung", "trung", "10d", 1);
    }
}
