/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quang
 */
public class productSize {

    private int productSize_id;
    private int product_id;
    private String size;
    private int quantity;

    public productSize() {
    }

    public productSize(int productSize_id, int product_id, String size, int quantity) {
        this.productSize_id = productSize_id;
        this.product_id = product_id;
        this.size = size;
        this.quantity = quantity;
    }

    public int getProductSize_id() {
        return productSize_id;
    }

    public void setProductSize_id(int productSize_id) {
        this.productSize_id = productSize_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "productSize{" + "productSize_id=" + productSize_id + ", product_id=" + product_id + ", size=" + size + ", quantity=" + quantity + '}';
    }

    
}
