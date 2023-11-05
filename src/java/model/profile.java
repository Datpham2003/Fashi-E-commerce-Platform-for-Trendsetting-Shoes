/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author acer
 */
public class profile {
    
    private int profile_id;
    private String image;
    private String full_name;
    private String phone;
    private String dob;
    private int gender;
    private String address;
    private String email;
    private Role role;
    private account account;

    public profile() {
    }

    public profile(int profile_id, String image, String full_name, String phone, String dob, int gender, String address, String email) {
        this.profile_id = profile_id;
        this.image = image;
        this.full_name = full_name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public profile(int profile_id, String image, String full_name, String phone, String dob, int gender, String address, String email, Role role, account account) {
        this.profile_id = profile_id;
        this.image = image;
        this.full_name = full_name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.role = role;
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public account getAccount() {
        return account;
    }

    public void setAccount(account account) {
        this.account = account;
    }
    
    

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "profile{" + "profile_id=" + profile_id + ", image=" + image + ", full_name=" + full_name + ", phone=" + phone + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", email=" + email + ", role=" + role + ", account=" + account + '}';
    }

    
}
