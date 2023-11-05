/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;

/**
 *
 * @author acer
 */
public class ShipDAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<OrderDetail> getAllOrder_Detail() {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select [order_id], [customer_id],[customer_name],[product_id],[product_quantity],[price],[order_date],[product_size],\n"
                + "[address],[phone],[note],[coupon_code],[order_status]  from Order_Detail";
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

    public void insertShip(int account_id, int order_id, String status, double deposit) {
        String sql = "INSERT INTO Shipper ([account_id],[order_id],[status],[shipper_deposit])\n"
                + "VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            ps.setInt(2, order_id);
            ps.setString(3, status);
            ps.setDouble(4, deposit);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(int order_id, String Status) {
        String sql = "UPDATE Order_Detail SET [order_status] = ? \n"
                + "Where order_id = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Status);
            ps.setInt(2, order_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatusShip(int order_id, String Status) {
        String sql = "UPDATE Shipper SET [status] = ? \n"
                + "Where order_id = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Status);
            ps.setInt(2, order_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void deleteOrderByOid(String order_id) {
        String sql = "DELETE FROM Order_Detail WHERE order_id = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, order_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getOrderIDByAccountID(int account_id) {
        int order_id = 0;
        String sql = "select order_id from Shipper where account_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            try ( ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    order_id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order_id;
    }

    public List<OrderDetail> getOrderHistory(int account_id) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "SELECT od.order_id, od.customer_id,od.customer_name,od.product_id,od.product_quantity,\n" +
                        "		od.price,od.order_date,od.product_size,od.address,od.phone,od.note,od.coupon_code,od.order_status\n" +
                        "FROM Shipper sh\n" +
                        "JOIN Order_Detail od ON sh.order_id = od.order_id\n" +
                        "WHERE sh.account_id = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
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
        ShipDAO dao = new ShipDAO();
         List<OrderDetail> list = dao.getOrderHistory(8);
        for (OrderDetail orderDetail : list) {
            System.out.println(orderDetail); 
       }

    }
}
