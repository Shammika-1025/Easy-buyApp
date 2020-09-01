package com.example.easybuy.Model;

public class Shops {
    private String ShopName;
    private String Address;
    private String Contact;
    private String Password;

    public Shops() {
    }

    public Shops(String shopName, String address, String contact, String password) {
        ShopName = shopName;
        Address = address;
        Contact = contact;
        Password = password;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
