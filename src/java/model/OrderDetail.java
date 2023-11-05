/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author quang
 */
public class OrderDetail{
    private int order_id;
    private int customer_id;
    private String customer_name;
    private int product_id;
    private int product_quantity;
    private double price;
    private Date order_date;
    private String size;
    private String address;
    private String phone;
    private String note;
    private String coupon_code;
    private String order_status;

    public OrderDetail() {
    }

    public OrderDetail(int order_id, int customer_id, String customer_name, int product_id, int product_quantity, double price, Date order_date, String size, String address, String phone, String note, String coupon_code, String order_status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.price = price;
        this.order_date = order_date;
        this.size = size;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.coupon_code = coupon_code;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order_id=" + order_id + ", customer_id=" + customer_id + ", customer_name=" + customer_name + ", product_id=" + product_id + ", product_quantity=" + product_quantity + ", price=" + price + ", order_date=" + order_date + ", size=" + size + ", address=" + address + ", phone=" + phone + ", note=" + note + ", coupon_code=" + coupon_code + ", order_status=" + order_status + '}';
    }

    

 
   
}
