/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Shipper {
    private int account_id;
    private int order_id;
    private String status;
    private double shipper_deposit;

    public Shipper() {
    }

    public Shipper(int account_id, int order_id, String status, double shipper_deposit) {
        this.account_id = account_id;
        this.order_id = order_id;
        this.status = status;
        this.shipper_deposit = shipper_deposit;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getShipper_deposit() {
        return shipper_deposit;
    }

    public void setShipper_deposit(double shipper_deposit) {
        this.shipper_deposit = shipper_deposit;
    }

    @Override
    public String toString() {
        return "Shipper{" + "account_id=" + account_id + ", order_id=" + order_id + ", status=" + status + ", shipper_deposit=" + shipper_deposit + '}';
    }
    
    
}
