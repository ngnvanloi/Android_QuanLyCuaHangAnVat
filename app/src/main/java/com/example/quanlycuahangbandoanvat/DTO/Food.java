package com.example.quanlycuahangbandoanvat.DTO;

public class Food {
    private String foodID;
    private String foodName;
    private String describe;
    private double price;
    private String status;
    private String promotionID;
    private String categoryID;
    private int quantityPurchased;
    private boolean isDeleted;
    private String hinh;

    public Food() {
    }

    public Food(String foodID, String foodName, String describe, double price, String status, String promotionID, String categoryID, int quantityPurchased, boolean isDeleted, String hinh) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.describe = describe;
        this.price = price;
        this.status = status;
        this.promotionID = promotionID;
        this.categoryID = categoryID;
        this.quantityPurchased = quantityPurchased;
        this.isDeleted = isDeleted;
        this.hinh = hinh;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
