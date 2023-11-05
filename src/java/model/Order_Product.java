/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author DanPC
 */
public class Order_Product {
    private int order_id;
    private int manager_id;
    private int provider_id;
    private int product_id;
    private String product_name;
    private String product_image;
    private int size;
    private int quantity; 
    private Date order_date;
    private String status;

    public Order_Product() {
    }

    public Order_Product(int order_id, int manager_id, int provider_id, int product_id, String product_name, String product_image, int size, int quantity, Date order_date, String status) {
        this.order_id = order_id;
        this.manager_id = manager_id;
        this.provider_id = provider_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_image = product_image;
        this.size = size;
        this.quantity = quantity;
        this.order_date = order_date;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order_Product{" + "order_id=" + order_id + ", manager_id=" + manager_id + ", provider_id=" + provider_id + ", product_id=" + product_id + ", product_name=" + product_name + ", product_image=" + product_image + ", size=" + size + ", quantity=" + quantity + ", order_date=" + order_date + ", status=" + status + '}';
    }

    
}