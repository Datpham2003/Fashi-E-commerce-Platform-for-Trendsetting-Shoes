/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;
import model.cart;

/**
 *
 * @author quang
 */
public class CheckOutDAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<cart> getAllCartByCustomerID(int customer_id) {
        List<cart> list = new ArrayList<>();
        String sql = "select *from Shopping_Cart where customer_id = ?";
        try {
            ps = connection.prepareStatement(sql);
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
            e.printStackTrace();
        }
        return list;
    }

    public List<OrderDetail> getAllOrder_DetailByCustomerID(int customer_id) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select [order_id],[customer_id],[customer_name],[product_id],[product_quantity],[price],[order_date],[product_size],\n"
                + "[address],[phone],[note],[coupon_code],[order_status] from Order_Detail where customer_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, customer_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertCheckOut(int customer_id, String customer_name, int product_id, int product_quanity,
            double price, Date order_date, String size, String address, String phone,
            String note, String coupon_code) {
        String querry = "insert into Order_Detail\n"
                + "([customer_id],[customer_name],[product_id],[product_quantity],[price],[order_date],[product_size],\n"
                + "[address],[phone],[note],[coupon_code])\n"
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(querry);
            ps.setInt(1, customer_id);
            ps.setString(2, customer_name);
            ps.setInt(3, product_id);
            ps.setInt(4, product_quanity);
            ps.setDouble(5, price);
            ps.setDate(6, order_date);
            ps.setString(7, size);
            ps.setString(8, address);
            ps.setString(9, phone);
            ps.setString(10, note);
            ps.setString(11, coupon_code);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public List<OrderDetail> getAllOrder_Detail() {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select [order_id],[customer_id],[customer_name],[product_id],[product_quantity],[price],[order_date],[product_size],\n"
                + "[address],[phone],[note],[coupon_code],[order_status] from Order_Detail";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        CheckOutDAO dao = new CheckOutDAO();
//        dao.insertCheckOut(1, "datpham1", 1, 2, 200, Date.valueOf(LocalDate.now()), "42", "105 phu doan", "0857138734", "okela", "datpham1");
        List<OrderDetail> list = dao.getAllOrder_DetailByCustomerID(1);
        for (OrderDetail orderDetail : list) {
            System.out.println(orderDetail); 
       }
        
    }
}
