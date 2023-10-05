/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quang
 */
public class product {

    private int product_id;
    private String product_image;
    private String product_name;
    private double product_price;
    private String product_description;
    private int cid;
    private int brand_id;

    public product() {
    }

    public product(int product_id, String product_image, String product_name, double product_price, String product_description, int cid, int brand_id) {
        this.product_id = product_id;
        this.product_image = product_image;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.cid = cid;
        this.brand_id = brand_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "product{" + "product_id=" + product_id + ", product_image=" + product_image + ", product_name=" + product_name + ", product_price=" + product_price + ", product_description=" + product_description + ", cid=" + cid + ", brand_id=" + brand_id + '}';
    }

}
