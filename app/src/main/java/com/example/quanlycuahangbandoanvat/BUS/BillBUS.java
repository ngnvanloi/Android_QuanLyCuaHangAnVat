package com.example.quanlycuahangbandoanvat.BUS;

import com.example.quanlycuahangbandoanvat.DTO.Bill;
import com.example.quanlycuahangbandoanvat.DTO.Cart;
import com.example.quanlycuahangbandoanvat.DTO.CartDetail;
import com.example.quanlycuahangbandoanvat.DTO.Food;

import java.util.ArrayList;

public class BillBUS {
    private ArrayList<Bill> listBill = new ArrayList<>();

    public ArrayList<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(ArrayList<Bill> listBill) {
        this.listBill = listBill;
    }

    public BillBUS(ArrayList<Bill> listBill) {
        this.listBill = listBill;
    }

    public BillBUS() {

    }
    public Bill getByBillID(String id) {
        int vitri = -1;
        int i = 0;
        for (i = 0; i < this.listBill.size(); i++) {
            if (this.listBill.get(i).getBill_ID().equals(id)) {
                vitri = i;
                break;
            }
        }
        if (vitri != -1) {
            return this.listBill.get(vitri);
        } else {
            return null;
        }
    }
    public Bill getBillByCustomerIDs(String id) {
        int vitri = -1;
        for (int i = 0; i < this.listBill.size(); i++) {
            if (this.listBill.get(i).getCus_ID().equals(id)) {
                vitri = i;
                break;
            }
        }
        if (vitri != -1) {
            return this.listBill.get(vitri);
        } else {
            return null;
        }
    }
}
