package com.example.quanlycuahangbandoanvat.DTO;

import java.util.Date;

public class Bill {
    private String Bill_ID;
    private String Cus_ID;
    private String Empl_ID;
    private Date Order_Date;
    private Date Delivery_Order;
    private String Bill_Status;

    public Bill() {
    }

    public Bill(String bill_ID, String cus_ID, String empl_ID, Date order_Date, Date delivery_Order, String bill_Status) {
        Bill_ID = bill_ID;
        Cus_ID = cus_ID;
        Empl_ID = empl_ID;
        Order_Date = order_Date;
        Delivery_Order = delivery_Order;
        Bill_Status = bill_Status;
    }

    public String getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        Bill_ID = bill_ID;
    }

    public String getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        Cus_ID = cus_ID;
    }

    public String getEmpl_ID() {
        return Empl_ID;
    }

    public void setEmpl_ID(String empl_ID) {
        Empl_ID = empl_ID;
    }

    public Date getOrder_Date() {
        return Order_Date;
    }

    public void setOrder_Date(Date order_Date) {
        Order_Date = order_Date;
    }

    public Date getDelivery_Order() {
        return Delivery_Order;
    }

    public void setDelivery_Order(Date delivery_Order) {
        Delivery_Order = delivery_Order;
    }

    public String getBill_Status() {
        return Bill_Status;
    }

    public void setBill_Status(String bill_Status) {
        Bill_Status = bill_Status;
    }
}
