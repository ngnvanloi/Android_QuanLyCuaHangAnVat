package com.example.quanlycuahangbandoanvat.DTO;

import java.util.Date;

public class Promotion {
    private String promotionID;
    private String promotionName;
    private Date dateStart;
    private Date dateEnd;
    private boolean isDeleted;
    private double discountAmount;

    public Promotion() {
    }

    public Promotion(String promotionID, String promotionName, Date dateStart, Date dateEnd, boolean isDeleted, double discountAmount) {
        this.promotionID = promotionID;
        this.promotionName = promotionName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.isDeleted = isDeleted;
        this.discountAmount = discountAmount;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
}
