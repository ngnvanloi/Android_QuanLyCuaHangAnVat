package com.example.quanlycuahangbandoanvat.DTO;

public class Customer {
    private String cusID;
    private String cusName;
    private String cusEmail;
    private String cusAddress;
    private String cusSex;
    private String cusPassword;
    private String cusPhone;

    public Customer() {
    }

    public Customer(String cusID, String cusName, String cusEmail, String cusAddress, String cusSex, String cusPassword, String cusPhone) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.cusAddress = cusAddress;
        this.cusSex = cusSex;
        this.cusPassword = cusPassword;
        this.cusPhone = cusPhone;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusSex() {
        return cusSex;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }
}
