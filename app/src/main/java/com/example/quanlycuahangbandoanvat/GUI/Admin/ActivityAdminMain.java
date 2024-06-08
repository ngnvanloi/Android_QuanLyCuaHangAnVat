package com.example.quanlycuahangbandoanvat.GUI.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.quanlycuahangbandoanvat.GUI.Admin.HomeFragment.HomeAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.LogoutFragment.LogoutAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.OrderFragment.OrderAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.Admin.Statistic_Fragment.StatisticAdminFragment;
import com.example.quanlycuahangbandoanvat.GUI.MainActivity;
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
                case R.id.navigation_statistic:
                    loadFragment(new StatisticAdminFragment());
                    break;
                case R.id.navigation_logout:
                    // Confirmation dialog before logout
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Xác nhận đăng xuất")
                            .setMessage("Bạn có chắc chắn muốn đăng xuất?")
                            .setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Dismiss dialog on cancel
                                    dialog.dismiss();
                                }
                            })
                            .show();

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