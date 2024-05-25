package com.example.quanlycuahangbandoanvat.DTO;

public class CartDetail {
    private String cartID;
    private String foodID;
    private int quantity;
    private Double totalCart;

    public CartDetail() {
    }

    public CartDetail(String cartID, String foodID, int quantity, Double totalCart) {
        this.cartID = cartID;
        this.foodID = foodID;
        this.quantity = quantity;
        this.totalCart = totalCart;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCart() {
        return totalCart;
    }

    public void setTotalCart(Double totalCart) {
        this.totalCart = totalCart;
    }
}
