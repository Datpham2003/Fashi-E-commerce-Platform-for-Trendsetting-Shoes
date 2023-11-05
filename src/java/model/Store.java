/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DanPC
 */
public class Store {
    private int product_id;
    private int product_import_size;
    private int total_import_quantity;

    public Store() {
    }

    public Store(int product_id, int product_import_size, int total_import_quantity) {
        this.product_id = product_id;
        this.product_import_size = product_import_size;
        this.total_import_quantity = total_import_quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_import_size() {
        return product_import_size;
    }

    public void setProduct_import_size(int product_import_size) {
        this.product_import_size = product_import_size;
    }

    public int getTotal_import_quantity() {
        return total_import_quantity;
    }

    public void setTotal_import_quantity(int total_import_quantity) {
        this.total_import_quantity = total_import_quantity;
    }

    @Override
    public String toString() {
        return "Store{" + "product_id=" + product_id + ", product_import_size=" + product_import_size + ", total_import_quantity=" + total_import_quantity + '}';
    }


   
    
}
