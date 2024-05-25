package com.example.quanlycuahangbandoanvat.DTO;

import java.util.Date;

public class Bill {
    private String billID;
    private String cusID;
    private String emplID;
    private Date orderDate;
    private Date deliveryOrder;
    private String billStatus;

    public Bill() {
    }

    public Bill(String billID, String cusID, String emplID, Date orderDate, Date deliveryOrder, String billStatus) {
        this.billID = billID;
        this.cusID = cusID;
        this.emplID = emplID;
        this.orderDate = orderDate;
        this.deliveryOrder = deliveryOrder;
        this.billStatus = billStatus;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getEmplID() {
        return emplID;
    }

    public void setEmplID(String emplID) {
        this.emplID = emplID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(Date deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}
