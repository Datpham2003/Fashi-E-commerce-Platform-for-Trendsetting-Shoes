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
import model.Import;
import model.Provider;
import model.product;
import model.productSize;

/**
 *
 * @author DanPC
 */
public class ProviderDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Import> getListImportProduct() {
        List<Import> list = new ArrayList<>();
        String sql = "select im.import_id,pv.provider_id,p.product_id, p.product_name, "
                + "im.product_import_quantity, im.import_date, pv.provider_name,"
                + " im.total_import_price, im.note from Import im \n"
                + "JOIN Provider pv ON pv.provider_id = im.import_id\n"
                + "JOIN Product p ON im.product_id =p.product_id";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Import im = new Import();
                im.setImport_id(rs.getInt("import_id"));
                im.setProduct_import_quantity(rs.getInt("product_import_quantity"));
                im.setImport_date(rs.getDate("import_date"));
                im.setTotal_import_price(rs.getDouble("total_import_price"));
                im.setNote(rs.getString("note"));
//                im.setProduct_id(rs.getInt("product_id"));
//                im.setProvider_id(rs.getInt("provider_id"));

                Provider pro = new Provider();
                pro.setProvider_id(rs.getInt("provider_id"));
                pro.setProvider_name(rs.getString("provider_name"));

                product p = new product();
                p.setProduct_id(rs.getInt("product_id"));
                p.setProduct_name(rs.getString("product_name"));
                im.setProduct(p);
                im.setProvider(pro);
                list.add(im);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {

        }
        return list;
    }

    public void deleteImportById(int id) {
        String sql = "DELETE FROM Import WHERE import_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Provider> getListProviderName() {
        List<Provider> list = new ArrayList<>();
        String sql = "select * from Provider";
        try {

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Provider(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }

        } catch (Exception e) {

        }
        return list;
    }

   

    public void AddNewImportById(int product_id, int product_import_quantity, int product_import_size, Date import_date, int manager_id,
            int provider_id, double total_import_price, String note) {
        String sql = "INSERT INTO Import(product_id, product_import_quantity, product_import_size, "
                + "import_date, manager_id, provider_id, total_import_price, note ) values \n"
                + "(?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, product_id);
            ps.setInt(2, product_import_quantity);
            ps.setInt(3, product_import_size);
            ps.setDate(4, import_date);
            ps.setInt(5, manager_id);
            ps.setInt(6, provider_id);
            ps.setDouble(7, total_import_price);
            ps.setString(8, note);

            // Thực thi câu lệnh
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//---------------------------------------------------------------------------------------------
    public List<Provider> getListProvider() {
        List<Provider> list = new ArrayList<>();
        String sql = "select * from Product_Size";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Provider(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void AddNewProvider(String provider_name, String provider_address, String provider_email, String provider_phone) {
        String sql = "INSERT INTO Provider( provider_name,  provider_address,  provider_email,  provider_phone) Values (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, provider_name);
            ps.setString(2, provider_address);
            ps.setString(3, provider_email);
            ps.setString(4, provider_phone);

            // Thực thi câu lệnh
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddNewImport(int product_id, int product_import_quantity, int product_import_size, String import_date, int manager_id, int provider_id, String note) {
        String sql = "INSERT INTO Import( product_id,  product_import_quantity, product_import_size,  import_date,  manager_id,  provider_id,  note) Values (?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, product_id);
            ps.setInt(2, product_import_quantity);
            ps.setInt(3, product_import_size);
            ps.setString(4, import_date);
            ps.setInt(5, provider_id);
            ps.setInt(6, manager_id);
            ps.setString(7, note);

            // Thực thi câu lệnh
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteImport(int import_id) {
        String sql = "DELETE FROM Product WHERE import_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, import_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public Import getListImportByID(int manager_id) {
        String sql = "select * from Import where manager_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, manager_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Import(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getDouble(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Import> getAllImportByID(int manager_id) {
        List<Import> im = new ArrayList<>();
        String sql = "select * from Import where manager_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                im.add(new Import(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getDouble(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return im;
    }

    public List<Import> getListImport() {
        List<Import> list = new ArrayList<>();
        String sql = "select *from Import";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Import(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getDouble(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<productSize> getListProductSize() {
        List<productSize> list = new ArrayList<>();
        String sql = "select * from Product_Size";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new productSize(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    

//    public int getTotalQuantityFromImportByManagerID(int manager_id, int product_id, int product_import_quantity ) {
//        int totalQuantity = 0;
//        String sql = "SELECT "
//                + "product_id, "
//                + "product_import_size, "
//                + "SUM(product_import_quantity) AS total_import_quantity "
//                + "FROM Import "
//                + "WHERE manager_id = ?, product_id= ?, product_import_quantity? "
//                + "GROUP BY product_id, product_import_size";
//        try {
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1, manager_id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                totalQuantity += rs.getInt("total_import_quantity");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return totalQuantity;
//    }
}
