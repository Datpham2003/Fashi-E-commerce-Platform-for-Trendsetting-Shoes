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
public class Import {

    private int import_id;
    private int product_id;
    private int product_import_quantity;
    private int product_import_size;
    private Date import_date;
    private int manager_id;
    private int provider_id;

    private double total_import_price;
    private String note;
    private product product;
    private Provider provider;

    public Import() {
    }

    public Import(int import_id, int product_id, int product_import_quantity, int product_import_size, Date import_date, int manager_id, int provider_id, double total_import_price, String note) {
        this.import_id = import_id;
        this.product_id = product_id;
        this.product_import_quantity = product_import_quantity;
        this.product_import_size = product_import_size;
        this.import_date = import_date;
        this.manager_id = manager_id;
        this.provider_id = provider_id;
        this.total_import_price = total_import_price;
        this.note = note;
    }

    public Import(int import_id, int product_id, int product_import_quantity, int product_import_size, Date import_date, int manager_id, int provider_id, double total_import_price, String note, product product, Provider provider) {
        this.import_id = import_id;
        this.product_id = product_id;
        this.product_import_quantity = product_import_quantity;
        this.product_import_size = product_import_size;
        this.import_date = import_date;
        this.manager_id = manager_id;
        this.provider_id = provider_id;
        this.total_import_price = total_import_price;
        this.note = note;
        this.product = product;
        this.provider = provider;
    }

    public int getImport_id() {
        return import_id;
    }

    public void setImport_id(int import_id) {
        this.import_id = import_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_import_quantity() {
        return product_import_quantity;
    }

    public void setProduct_import_quantity(int product_import_quantity) {
        this.product_import_quantity = product_import_quantity;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    public int getProduct_import_size() {
        return product_import_size;
    }

    public void setProduct_import_size(int product_import_size) {
        this.product_import_size = product_import_size;
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

    public double getTotal_import_price() {
        return total_import_price;
    }

    public void setTotal_import_price(double total_import_price) {
        this.total_import_price = total_import_price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Import{" + "import_id=" + import_id + ", product_id=" + product_id + ", product_import_quantity=" + product_import_quantity + ", product_import_size=" + product_import_size + ", import_date=" + import_date + ", manager_id=" + manager_id + ", provider_id=" + provider_id + ", total_import_price=" + total_import_price + ", note=" + note + ", product=" + product + ", provider=" + provider + '}';
    }

}
