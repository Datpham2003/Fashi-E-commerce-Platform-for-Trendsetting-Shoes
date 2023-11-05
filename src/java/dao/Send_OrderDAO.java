/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Order_Product;
import model.productSize;

/**
 *
 * @author DanPC
 */
public class Send_OrderDAO extends DBContext {


    public List<Order_Product> getAllOrderProductByManagerId() {
        List<Order_Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Order_Product";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order_Product(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDate(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<productSize> getAllProductSize() {
        List<productSize> list = new ArrayList<>();

        return list;
    }

    public void SendOrder(int manager_id, int provider_id, int product_id, String product_name, String product_image, int quantity, int size, Date order_date) {
        String sql = "INSERT INTO Order_Product(manager_id,provider_id,product_id,quantity, size, order_date, status ) "
                + "Values(?,?,?,?,?,?,'send');";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, manager_id);
            ps.setInt(2, provider_id);
            ps.setInt(3, product_id);
            ps.setString(4, product_name);
            ps.setString(5, product_image);
            ps.setInt(6, quantity);
            ps.setInt(7, size);
            ps.setDate(8, new java.sql.Date(order_date.getTime()));
            ps.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void acceptOrder(int order_id) {
        String sql = "UPDATE Order_Product Set status = 'Accepted' where order_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void rejectedOrder(int order_id) {
        String sql = "UPDATE Order_Product Set status = 'Rejected' where order_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        AccountDAO dao = new AccountDAO();
//        ProviderDAO dao_1 = new ProviderDAO();

//        List<Profile> pro = dao.getAllProfileByAccount();
//        System.out.println(pro);
//        Profile pro = dao.getProfileById(1);
//        account ac = dao.getAccountById(2);
//        List<Profile> pro_2 = dao.getAllProfileByAccount();
//        List<Import> im = dao_1.getListImportProduct();
//         ProductDAO dao_2 = new ProductDAO();
//        List<Product_1> p = dao_2.GetListProductOrder();
//        List<product> product = dao_2.getAllProductByBID("1");
        Send_OrderDAO send = new Send_OrderDAO();        
        List<Order_Product> op = send.getAllOrderProductByManagerId();
        for (Order_Product order_Product : op) {
             System.out.println(order_Product);
        }  
    }
}