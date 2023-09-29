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
import model.brand;
import model.category;
import model.product;
import model.productSize;

/**
 *
 * @author quang
 */
public class ProductDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<product> getAllProduct() {
        List<product> list = new ArrayList<>();
        String sql = "select *from Product";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> getTopFourMenProduct() {
        List<product> list = new ArrayList<>();
        String sql = "select Top 4 *from Product where category_id = 6";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> getTopFourWomenProduct() {
        List<product> list = new ArrayList<>();
        String sql = "select Top 4 *from Product where category_id = 7";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<category> getAllCategory() {
        List<category> list = new ArrayList<>();
        String sql = "select *from Category";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<brand> getAllBrand() {
        List<brand> list = new ArrayList<>();
        String sql = "select *from Brand";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new brand(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<String> getAllProductSizes() {

        List<String> list = new ArrayList<>();

        String sql = "SELECT DISTINCT size FROM Product_Size";

        try {

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {
                list.add(rs.getString(1));
            }

        } catch (Exception e) {

        }

        return list;
    }

//    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//        List<String> list = dao.getAllProductSizes();
//        for (String string : list) {
//            System.out.println(string);
//        }
//    }
}
