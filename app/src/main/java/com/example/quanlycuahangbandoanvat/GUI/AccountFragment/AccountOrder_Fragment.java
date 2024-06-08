package com.example.quanlycuahangbandoanvat.GUI.AccountFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlycuahangbandoanvat.Adapter.CustomAdapterRecycleViewOderBillTrue;
import com.example.quanlycuahangbandoanvat.BUS.BillBUS;
import com.example.quanlycuahangbandoanvat.DAO.BillDAO;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCalbackBill;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackCart;
import com.example.quanlycuahangbandoanvat.DAO.CartDAO;
import com.example.quanlycuahangbandoanvat.DTO.Bill;
import com.example.quanlycuahangbandoanvat.DTO.Cart;
import com.example.quanlycuahangbandoanvat.R;

import java.util.ArrayList;

public class AccountOrder_Fragment extends Fragment {

    private RecyclerView recyclerViewOderBillTrue;
    private CustomAdapterRecycleViewOderBillTrue recyclerViewOderBillTrueAdapter;
    private ArrayList<Bill> listBill = new ArrayList<>();
    private BillDAO billDAO = new BillDAO();
    private CartDAO cartDAO = new CartDAO();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_order_, container, false);
        String current_cusID = getCustomerIDFromSharedReferences();

        // Controls
        recyclerViewOderBillTrue = view.findViewById(R.id.recyclerViewTrue);
        recyclerViewOderBillTrue.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load bills for the current customer
        loadBills(current_cusID);

        return view;
    }

    private void loadBills(String current_cusID) {
        cartDAO.selectAll(new OnDataLoadedCallbackCart() {
            @Override
            public void onDataLoaded(ArrayList<Cart> carts) {
                listBill.clear();
                for (Cart cart : carts) {
                    if (cart.getCus_ID().equals(current_cusID) && cart.getPayment()) {
                        billDAO.selectAll(new OnDataLoadedCalbackBill() {
                            @Override
                            public void onDataLoaded(ArrayList<Bill> bills) {
                                for (Bill bill : bills) {
                                    if (bill.getCart_ID() != null && bill.getCart_ID().equals(cart.getCart_ID())) {
                                        listBill.add(bill);
                                    }
                                }
                                updateRecyclerView();
                            }

                            @Override
                            public void onError(String errorMessage) {
                                // Handle error
                            }
                        });
                    }
                }
            }

            @Override
            public void onDataLoadedSigle(Cart cart) {
                // Not used
            }

            @Override
            public void onError(String errorMessage) {
                // Handle error
            }
        });
    }

    private void updateRecyclerView() {
        recyclerViewOderBillTrueAdapter = new CustomAdapterRecycleViewOderBillTrue(getContext(), listBill);
        recyclerViewOderBillTrue.setAdapter(recyclerViewOderBillTrueAdapter);
    }

    private String getCustomerIDFromSharedReferences() {
        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString("current_customer_id", "");
    }
}