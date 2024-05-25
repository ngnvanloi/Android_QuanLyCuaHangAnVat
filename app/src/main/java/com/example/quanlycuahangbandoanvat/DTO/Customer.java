package com.example.quanlycuahangbandoanvat.DTO;

public class Customer {
    private String Cus_ID;
    private String Cus_Name;
    private String Cus_Email;
    private String Cus_Address;
    private String Cus_Sex;
    private String Cus_Password;
    private String Cus_Phone;

    public Customer() {
    }

    public Customer(String cus_ID, String cus_Name, String cus_Email, String cus_Address, String cus_Sex, String cus_Password, String cus_Phone) {
        Cus_ID = cus_ID;
        Cus_Name = cus_Name;
        Cus_Email = cus_Email;
        Cus_Address = cus_Address;
        Cus_Sex = cus_Sex;
        Cus_Password = cus_Password;
        Cus_Phone = cus_Phone;
    }

    public String getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        Cus_ID = cus_ID;
    }

    public String getCus_Name() {
        return Cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        Cus_Name = cus_Name;
    }

    public String getCus_Email() {
        return Cus_Email;
    }

    public void setCus_Email(String cus_Email) {
        Cus_Email = cus_Email;
    }

    public String getCus_Address() {
        return Cus_Address;
    }

    public void setCus_Address(String cus_Address) {
        Cus_Address = cus_Address;
    }

    public String getCus_Sex() {
        return Cus_Sex;
    }

    public void setCus_Sex(String cus_Sex) {
        Cus_Sex = cus_Sex;
    }

    public String getCus_Password() {
        return Cus_Password;
    }

    public void setCus_Password(String cus_Password) {
        Cus_Password = cus_Password;
    }

    public String getCus_Phone() {
        return Cus_Phone;
    }

    public void setCus_Phone(String cus_Phone) {
        Cus_Phone = cus_Phone;
    }
}
