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
public class CheckOutDAO extends DBContext {

    Connection conn = null;
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

//    public static void main(String[] args) {
//        CheckOutDAO dao = new CheckOutDAO();
//        List<cart> a = dao.getAllCartByCustomerID(1);
//        for (cart object : a) {
//            System.out.println(object);
//        }
//    }
}
