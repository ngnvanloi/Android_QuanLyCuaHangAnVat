package com.example.quanlycuahangbandoanvat.DTO;


public class BillDetail {
    private String Bill_ID;
    private String Food_ID;
    private int Food_count;
    private Double Total_Bill;

    public BillDetail() {
    }

    public BillDetail(String bill_ID, String food_ID, int food_count, Double total_Bill) {
        Bill_ID = bill_ID;
        Food_ID = food_ID;
        Food_count = food_count;
        Total_Bill = total_Bill;
    }

    public String getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        Bill_ID = bill_ID;
    }

    public String getFood_ID() {
        return Food_ID;
    }

    public void setFood_ID(String food_ID) {
        Food_ID = food_ID;
    }

    public int getFood_count() {
        return Food_count;
    }

    public void setFood_count(int food_count) {
        Food_count = food_count;
    }

    public Double getTotal_Bill() {
        return Total_Bill;
    }

    public void setTotal_Bill(Double total_Bill) {
        Total_Bill = total_Bill;
    }
}
