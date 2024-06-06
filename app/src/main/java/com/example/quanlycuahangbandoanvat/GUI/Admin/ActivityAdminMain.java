package com.example.quanlycuahangbandoanvat.GUI.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.quanlycuahangbandoanvat.GUI.Admin.CustomFragment.CustomAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.FoodFragment.FoodAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.HomeFragment.HomeAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.LogoutFragment.LogoutAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.OrderFragment.OrderAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Account;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Carts;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Home;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Location;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Menu;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.NoLoginCart;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Voucher;
import com.example.quanlycuahangbandoanvat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityAdminMain extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayoutMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        frameLayoutMainActivity = findViewById(R.id.FrameLayoutMainActivity);
        bottomNavigationView = findViewById(R.id.BottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_homeadmin);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_homeadmin:
                    loadFragment(new HomeAdminFragment());
                    break;
                case R.id.navigation_order:
                    loadFragment(new OrderAdminFragment());
                    break;
                case R.id.navigation_customer:
                    loadFragment(new CustomAdminFragment());
                    break;
                case R.id.navigation_food:
                    loadFragment(new FoodAdminFragment());
                    break;
                case R.id.navigation_logout:
                    loadFragment(new LogoutAdminFragment());
                    break;
                default:
                    return false;
            }
            return true;
        });
        loadFragment(new HomeAdminFragment());
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayoutMainActivity, fragment);
        fragmentTransaction.commit();
    }
}