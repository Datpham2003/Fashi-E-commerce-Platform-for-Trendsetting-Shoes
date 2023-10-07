/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author quang
 */
public class CartDAO extends DBContext{
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void insertCart(String name, String image,
            String price, String title, String description,
            String category, int sid) {
        String querry = "insert into product\n"
                + "([name],[image],[price],[title],[description],[cateID],[sell_ID])\n"
                + "values (?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(querry);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
