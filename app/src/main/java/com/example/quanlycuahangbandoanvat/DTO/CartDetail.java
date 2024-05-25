package com.example.quanlycuahangbandoanvat.DTO;

public class CartDetail {
    private String Cart_ID;
    private String Food_ID;
    private int Quantity;
    private Double Total_Cart;

    public CartDetail() {
    }

    public CartDetail(String cart_ID, String food_ID, int quantity, Double total_Cart) {
        Cart_ID = cart_ID;
        Food_ID = food_ID;
        Quantity = quantity;
        Total_Cart = total_Cart;
    }

    public String getCart_ID() {
        return Cart_ID;
    }

    public void setCart_ID(String cart_ID) {
        Cart_ID = cart_ID;
    }

    public String getFood_ID() {
        return Food_ID;
    }

    public void setFood_ID(String food_ID) {
        Food_ID = food_ID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Double getTotal_Cart() {
        return Total_Cart;
    }

    public void setTotal_Cart(Double total_Cart) {
        Total_Cart = total_Cart;
    }
}
