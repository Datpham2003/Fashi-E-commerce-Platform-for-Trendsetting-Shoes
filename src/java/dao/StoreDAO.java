/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Import;
import model.Provider;
import model.Store;
import model.brand;
import model.category;
import model.product;
import model.productSize;

/**
 *
 * @author DanPC
 */
public class StoreDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<product> getListProduct() {
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

    public List<category> getListCategory() {
        List<category> list = new ArrayList<>();
        String sql = "select *from Category";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new category(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<brand> getListBrand() {
        List<brand> list = new ArrayList<>();
        String sql = "select *from Brand";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new brand(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Provider> getListProvider() {
        List<Provider> list = new ArrayList<>();
        String sql = "select *from Product";
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

    public void AddNewProviderByID() {
        String sql = "";
    }

    public void AddNewProduct(String product_image, String product_name, double product_price, String product_description, int category_id, int brand_id) {
        String sql = "INSERT INTO Product(product_image, product_name, product_price, product_description, category_id, brand_id) Values (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, product_image);
            ps.setString(2, product_name);
            ps.setDouble(3, product_price);
            ps.setString(4, product_description);
            ps.setInt(5, category_id);
            ps.setInt(6, brand_id);

            // Thực thi câu lệnh
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int AddNewProduct_1(String product_image, String product_name, double product_price, String product_description, int category_id, int brand_id) {
        String sql = "INSERT INTO Product(product_image, product_name, product_price, product_description, category_id, brand_id) Values (?,?,?,?,?,?)";
        int generatedKey = 0;
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product_image);
            ps.setString(2, product_name);
            ps.setDouble(3, product_price);
            ps.setString(4, product_description);
            ps.setInt(5, category_id);
            ps.setInt(6, brand_id);

            // Thực thi câu lệnh
            ps.executeUpdate();

            // Lấy ra product_id được tự sinh
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedKey; // Trả về product_id tự sinh
    }

    public void AddNewProductSize(int product_id, int size, int quantity) {
        String sql = "INSERT INTO Product_Size(product_id, size, quantity) values (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, product_id);
            ps.setInt(2, size);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddNewBrand(String brand_name) {
        String sql = "INSERT INTO Brand(brand_name) values (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, brand_name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddNewCategory(String category_name) {
        String sql = "INSERT INTO Category(category_name) values (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, category_name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public product getProductById(int id) {
        String sql = "select * from Product where product_id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new product(
                        rs.getInt(1),
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

    public void UpdateProductByProductID(int product_id, String product_image, String product_name, double product_price, String product_description, int cid, int brand_id) {
        String updateProfileSql = "UPDATE Product SET product_image = ?, product_name = ?, product_price = ?, product_description = ?, category_id = ?, brand_id = ? WHERE product_id = ?";
        try {
            ps = connection.prepareStatement(updateProfileSql);
            ps.setString(1, product_image);
            ps.setString(2, product_name);
            ps.setDouble(3, product_price);
            ps.setString(4, product_description);
            ps.setInt(5, cid);
            ps.setInt(6, brand_id);
            ps.setInt(7, product_id);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Store> getListStore(int manager_id) {
        List<Store> storeList = new ArrayList<>();
        String query = "SELECT product_id, product_import_size, SUM(product_import_quantity) AS total_import_quantity FROM Import WHERE manager_id = ? GROUP BY product_id, product_import_size";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, manager_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {            
                int product_id = rs.getInt("product_id");
                int product_import_size = rs.getInt("product_import_size");
                int total_import_quantity = rs.getInt("total_import_quantity");
                Store store = new Store(product_id, product_import_size, total_import_quantity);
                storeList.add(store);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return storeList;
    }
    
    
      
}
