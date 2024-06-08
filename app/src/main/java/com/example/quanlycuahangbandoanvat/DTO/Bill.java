package com.example.quanlycuahangbandoanvat.DTO;

import java.util.Date;

public class Bill {
    private String Bill_ID;
    private String Cart_ID;
    private String Cus_ID;
    private String Food_Promotion_ID;
    private Date Order_Date;
    private Date Delivery_Order;
    private String Bill_Status;
    private Double Total_Bill;

    public Bill(){

    }

    public Bill(String bill_ID, String cart_ID, String cus_ID, String food_Promotion_ID, Date order_Date, Date delivery_Order, String bill_Status, Double total_Bill) {
        Bill_ID = bill_ID;
        Cart_ID = cart_ID;
        Cus_ID = cus_ID;
        Food_Promotion_ID = food_Promotion_ID;
        Order_Date = order_Date;
        Delivery_Order = delivery_Order;
        Bill_Status = bill_Status;
        Total_Bill = total_Bill;
    }

    public String getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        Bill_ID = bill_ID;
    }

    public String getCart_ID() {
        return Cart_ID;
    }

    public void setCart_ID(String cart_ID) {
        Cart_ID = cart_ID;
    }

    public String getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(String cus_ID) {
        Cus_ID = cus_ID;
    }

    public String getFood_Promotion_ID() {
        return Food_Promotion_ID;
    }

    public void setFood_Promotion_ID(String food_Promotion_ID) {
        Food_Promotion_ID = food_Promotion_ID;
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

    public Double getTotal_Bill() {
        return Total_Bill;
    }

    public void setTotal_Bill(Double total_Bill) {
        Total_Bill = total_Bill;
    }
}
