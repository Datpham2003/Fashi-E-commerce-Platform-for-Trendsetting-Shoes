import dao.AccountDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import dao.Send_OrderDAO;
import dao.StoreDAO;
import java.util.List;
import model.Import;
import model.Order_Product;
import model.profile;
import model.Role;
import model.Store;
import model.account;
import model.brand;
import model.category;
import model.product;
import model.productSize;

/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
/**
 *
 
@author DanPC*/
public class test {

    public static void main(String[] args) {
        ProviderDAO provider = new ProviderDAO();
          provider.AddNewImport(5, 1, 34, "2002/07/07", 1, 1, "good");
          
    }
}