/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class account {
    private int idAccount;
    private String  username ;
    private String  password ;
    private int  idRole;
    private int  idProfile;
    

    public account() {
    }

    public account(int idAccount, String username, String password, int idRole, int idProfile) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.idRole = idRole;
        this.idProfile = idProfile;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    @Override
    public String toString() {
        return "account{" + "idAccount=" + idAccount + ", username=" + username + ", password=" + password + ", idRole=" + idRole + ", idProfile=" + idProfile + '}';
    }

   

    

    
    
    
    
}
