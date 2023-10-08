/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quang
 */
public class cart {
    private int cart_id;
    private int product_id;
    private int quantity;
    private int customer_id;
    private String product_size;

    public cart() {
    }

    public cart(int cart_id, int product_id, int quantity, int customer_id, String product_size) {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.customer_id = customer_id;
        this.product_size = product_size;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    @Override
    public String toString() {
        return "cart{" + "cart_id=" + cart_id + ", product_id=" + product_id + ", quantity=" + quantity + ", customer_id=" + customer_id + ", product_size=" + product_size + '}';
    }
  
}
