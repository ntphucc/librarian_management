/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Account {
    private String id;
    private String fullName;
    private String phone;
    private String citizen_identity_card;
    private String address;
    private String mail;
    private String username;
    private String password;
    private String  role;

    public Account(String id,String role, String fullName, String phone, String citizen_identity_card, String address, String mail, String username, String password ) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.citizen_identity_card = citizen_identity_card;
        this.address = address;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account(String id, String fullName, String phone, String citizen_identity_card, String address, String mail, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.citizen_identity_card = citizen_identity_card;
        this.address = address;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCitizen_identity_card() {
        return citizen_identity_card;
    }

    public void setCitizen_identity_card(String citizen_identity_card) {
        this.citizen_identity_card = citizen_identity_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", fullName=" + fullName + ", phone=" + phone + ", citizen_identity_card=" + citizen_identity_card + ", address=" + address + ", mail=" + mail + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

   
    
}
