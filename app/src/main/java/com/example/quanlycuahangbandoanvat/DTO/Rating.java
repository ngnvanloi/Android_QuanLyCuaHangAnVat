package com.example.quanlycuahangbandoanvat.DTO;

import java.util.Date;

public class Rating {
    private String ratingID;
    private String billID;
    private String ratingComment;
    private Date ratingDate;

    public Rating() {
    }

    public Rating(String ratingID, String billID, String ratingComment, Date ratingDate) {
        this.ratingID = ratingID;
        this.billID = billID;
        this.ratingComment = ratingComment;
        this.ratingDate = ratingDate;
    }

    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }
}
