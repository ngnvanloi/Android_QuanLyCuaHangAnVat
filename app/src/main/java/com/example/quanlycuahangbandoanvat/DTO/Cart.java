package com.example.quanlycuahangbandoanvat.DTO;

public class Cart {
    private String cartID;
    private String cusID;

    public Cart() {
    }

    public Cart(String cartID, String cusID) {
        this.cartID = cartID;
        this.cusID = cusID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
}
