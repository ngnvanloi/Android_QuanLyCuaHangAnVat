package com.example.quanlycuahangbandoanvat.GUI.MainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.quanlycuahangbandoanvat.Adapter.MyViewPageAdapter_Menu;
import com.example.quanlycuahangbandoanvat.R;
import com.google.android.material.tabs.TabLayout;

public class Menu extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mView;


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
//        tabLayout.addOnTabSelectedListener();

        return mView;
    }
}