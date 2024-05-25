package com.example.quanlycuahangbandoanvat.DTO;


public class BillDetail {
    private String billID;
    private String foodID;
    private int foodCount;
    private Double totalBill;

    public BillDetail() {
    }

    public BillDetail(String billID, String foodID, int foodCount, Double totalBill) {
        this.billID = billID;
        this.foodID = foodID;
        this.foodCount = foodCount;
        this.totalBill = totalBill;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }
}
