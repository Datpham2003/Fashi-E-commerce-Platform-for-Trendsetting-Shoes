/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DanPC
 */
public class Provider {
    private int provider_id;
    private String provider_name;
    private String provider_address;
    private String provider_email;
    private String provider_phone;

    public Provider() {
    }

    public Provider(int provider_id, String provider_name, String provider_address, String provider_email, String provider_phone) {
        this.provider_id = provider_id;
        this.provider_name = provider_name;
        this.provider_address = provider_address;
        this.provider_email = provider_email;
        this.provider_phone = provider_phone;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_address() {
        return provider_address;
    }

    public void setProvider_address(String provider_address) {
        this.provider_address = provider_address;
    }

    public String getProvider_email() {
        return provider_email;
    }

    public void setProvider_email(String provider_email) {
        this.provider_email = provider_email;
    }

    public String getProvider_phone() {
        return provider_phone;
    }

    public void setProvider_phone(String provider_phone) {
        this.provider_phone = provider_phone;
    }

    @Override
    public String toString() {
        return "Provider{" + "provider_id=" + provider_id + ", provider_name=" + provider_name + ", provider_address=" + provider_address + ", provider_email=" + provider_email + ", provider_phone=" + provider_phone + '}';
    }
    
}
