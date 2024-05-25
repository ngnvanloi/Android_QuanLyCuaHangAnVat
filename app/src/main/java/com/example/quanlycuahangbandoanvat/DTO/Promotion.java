package com.example.quanlycuahangbandoanvat.DTO;

import java.util.Date;

public class Promotion {
    private String Food_Promotion_ID;
    private String Promotion_Name;
    private Date Date_Start;
    private Date Date_End;
    private boolean IsDeleted;
    private double Discount_Amount;

    public Promotion() {
    }

    public Promotion(String food_Promotion_ID, String promotion_Name, Date date_Start, Date date_End, boolean isDeleted, double discount_Amount) {
        Food_Promotion_ID = food_Promotion_ID;
        Promotion_Name = promotion_Name;
        Date_Start = date_Start;
        Date_End = date_End;
        IsDeleted = isDeleted;
        Discount_Amount = discount_Amount;
    }

    public String getFood_Promotion_ID() {
        return Food_Promotion_ID;
    }

    public void setFood_Promotion_ID(String food_Promotion_ID) {
        Food_Promotion_ID = food_Promotion_ID;
    }

    public String getPromotion_Name() {
        return Promotion_Name;
    }

    public void setPromotion_Name(String promotion_Name) {
        Promotion_Name = promotion_Name;
    }

    public Date getDate_Start() {
        return Date_Start;
    }

    public void setDate_Start(Date date_Start) {
        Date_Start = date_Start;
    }

    public Date getDate_End() {
        return Date_End;
    }

    public void setDate_End(Date date_End) {
        Date_End = date_End;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public double getDiscount_Amount() {
        return Discount_Amount;
    }

    public void setDiscount_Amount(double discount_Amount) {
        Discount_Amount = discount_Amount;
    }
}
