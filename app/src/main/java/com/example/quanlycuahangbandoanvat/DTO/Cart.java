package com.example.quanlycuahangbandoanvat.DTO;

public class Cart {
    private String Cart_ID;
    private String Cus_ID;

    public Cart() {
    }

    public Cart(String cart_ID, String cus_ID) {
        Cart_ID = cart_ID;
        Cus_ID = cus_ID;
    }

    public String getCart_ID() {
        return Cart_ID;
    }

    public void setCart_ID(String cart_ID) {
        Cart_ID = cart_ID;
    }

    public String getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        Cus_ID = cus_ID;
    }
}
