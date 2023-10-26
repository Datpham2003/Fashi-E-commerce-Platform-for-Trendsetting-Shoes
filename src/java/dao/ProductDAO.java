/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.brand;
import model.cart;
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();

        }

        return list;
    }

    public product getProductByID(int id) {
        String sql = "select *from Product where product_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<productSize> getProductSizeByID(int id) {
        List<productSize> list = new ArrayList<>();
        String sql = "select *from Product_Size where product_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new productSize(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<product> getProductByBrandID(String[] ids) {
        List<product> list = new ArrayList<>();
        String sql = "SELECT name FROM Product WHERE id IN (:?)";
        try {
            ps = connection.prepareStatement(sql);
            Array idArr = connection.createArrayOf("VARCHAR", ids);
            ps.setArray(1, idArr);
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
            e.printStackTrace();
        }
        return list;
    }

    public List<product> getTopRelatedProduct(String bid, String cid) {
        List<product> list = new ArrayList<>();
        String sql = "SELECT TOP 4 *\n"
                + "FROM Product\n"
                + "WHERE brand_id = ? and category_id = ?\n"
                + "ORDER BY NEWID()";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, bid);
            ps.setString(2, cid);
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
            e.printStackTrace();
        }
        return list;
    }

    public productSize getQuantityBySizeAndPID(int product_id, String size) {
        String sql = "select *from Product_Size "
                + "where product_id = ? "
                + "and size = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, product_id);
            ps.setString(2, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new productSize(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<productSize> getProductSize() {
        List<productSize> list = new ArrayList<>();
        String sql = "select *from Product_Size";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new productSize(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateProductSize(int product_id,String size,int quantity) {
        String querry = "update Product_Size\n"
                + "set quantity = ?\n"
                + "where product_id = ? and size = ?;";
        try {
            ps = connection.prepareStatement(querry);
            ps.setInt(1, quantity);
            ps.setInt(2, product_id);
            ps.setString(3, size);
            ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//        List<productSize> list = dao.getProductSize();
//        for (productSize size : list) {
//            System.out.println(size);
//        }
//    }
}
