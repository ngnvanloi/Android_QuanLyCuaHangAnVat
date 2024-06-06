package com.example.quanlycuahangbandoanvat.GUI.MainFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.quanlycuahangbandoanvat.Adapter.MyViewPageAdapter_Menu;
import com.example.quanlycuahangbandoanvat.BUS.CartBUS;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackCart;
import com.example.quanlycuahangbandoanvat.DAO.CartDAO;
import com.example.quanlycuahangbandoanvat.DTO.Cart;
import com.example.quanlycuahangbandoanvat.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Menu extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mView;
    CartDAO cartDAO = new CartDAO();
    CartBUS cartBUS = new CartBUS();
    public Menu() {
        // Required empty public constructor
    }
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_menu, container, false);
        tabLayout=mView.findViewById(R.id.tabLayout_Menu);
        viewPager=mView.findViewById(R.id.menu_ViewPage);
        MyViewPageAdapter_Menu adapter=new MyViewPageAdapter_Menu(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
//      tabLayout.addOnTabSelectedListener();

        //Add cart_ID
        String cus_id = getCustomerIDFromSharedReferences();
        cartDAO.selectAll(new OnDataLoadedCallbackCart() {
            @Override
            public void onDataLoaded(ArrayList<Cart> t) {
                cartBUS = new CartBUS(t);
                if (!cus_id.equals("")) {
                    Cart cart = cartBUS.getCartByCustomerIDs(cus_id);
                    if (cart != null) { // Kiểm tra xem cart có null hay không
                        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("current_cart_id", cart.getCart_ID());
                        editor.apply();
                    } else {

                    }
                }
            }
            @Override
            public void onError(String errorMessage) {

            }

            @Override
            public void onDataLoadedSigle(Cart cart) {

            }
        });
        return mView;
    }
    private String getCustomerIDFromSharedReferences(){
        SharedPreferences sharedPref =  requireActivity().getPreferences(Context.MODE_PRIVATE);
        String currentCustomerID = sharedPref.getString("current_customer_id", "");
        return currentCustomerID;
    }

}