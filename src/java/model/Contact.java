/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class Contact {
    private int contact_id;
    private String name;
    private String email;
    private String mess;
    private int account_id;

    public Contact() {
    }

    public Contact(int contact_id, String name, String email, String mess, int account_id) {
        this.contact_id = contact_id;
        this.name = name;
        this.email = email;
        this.mess = mess;
        this.account_id = account_id;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Contact{" + "contact_id=" + contact_id + ", name=" + name + ", email=" + email + ", mess=" + mess + ", account_id=" + account_id + '}';
    }
    
    
}
