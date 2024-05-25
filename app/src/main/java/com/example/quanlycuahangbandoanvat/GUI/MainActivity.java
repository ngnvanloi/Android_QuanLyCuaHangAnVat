package com.example.quanlycuahangbandoanvat.GUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.quanlycuahangbandoanvat.Config.InitDatabase;
import com.example.quanlycuahangbandoanvat.GUI.Interface.OnNavigationLinkClickListener;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Account;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Cart;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Home;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Location;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Login;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Menu;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Option;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Register;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Voucher;
import com.example.quanlycuahangbandoanvat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  implements OnNavigationLinkClickListener {
    BottomNavigationView bottomNavigationView;
    ImageView imageViewAccountNavigation, imageViewHomeNavigation, imageViewOptionNavigation;
    FrameLayout frameLayoutMainActivity;
   Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ ID
        bottomNavigationView = findViewById(R.id.BottomNavigation);
        frameLayoutMainActivity = findViewById(R.id.FrameLayoutMainActivity);
        imageViewHomeNavigation = findViewById(R.id.imageViewHomeNavigation);
        imageViewAccountNavigation = findViewById(R.id.imageViewAccountNavigation);
        imageViewOptionNavigation = findViewById(R.id.imageViewOptionNavigation);

        // init database QuanLyCuaHangBanDoAnVat
        //InitDatabase initDatabase = new InitDatabase(this);
        //initDatabase.initData();

        //toolbar
        toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // DEFAULT
        bottomNavigationView.setSelectedItemId(R.id.navigation_home); // set default item Home was checked



        // TOP NAVIGATION ITEM
        imageViewHomeNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Home());
            }
        });
        imageViewAccountNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUserLoggedIn()) {
                    loadFragment(new Account());
                } else {
                    loadFragment(new Register());
                }
            }
        });
        imageViewOptionNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Option());
            }
        });


        // BOTTOM NAVIGATION ITEM
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if (itemID == R.id.navigation_home) {
                    loadFragment(new Home());

                }
                else if(itemID == R.id.navigation_voucher) {
                    loadFragment(new Voucher());
                }
                else if(itemID == R.id.navigation_cart) {
                    loadFragment(new Cart());
                }
                else if(itemID == R.id.navigation_menu) {
                    loadFragment(new Menu());
                }
                else if(itemID == R.id.navigation_location) {
                    loadFragment(new Location());
                }
                return true;
            }

        });
        loadFragment(new Home());
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayoutMainActivity, fragment);
        fragmentTransaction.commit();
    }
    // Override phương thức từ Interface để xử lý sự kiện khi TextView "Đăng kí" được click
    @Override
    public void onRegisterLinkClicked() {
        loadFragment(new Register());
    }

    // Override phương thức từ Interface để xử lý sự kiện khi TextView "Đăng nhập" được click
    @Override
    public void onLoginLinkClicked() {
        loadFragment(new Login());
    }
    // Phương thức này được gọi khi TextView "Đăng kí" được click
    public void onRegisterLinkClick(View view) {
        loadFragment(new Register());
    }
    public void onLoginLinkClick(View view) {
        loadFragment(new Login());
    }
    private boolean isUserLoggedIn() {
        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        // Trả về true nếu đã đăng nhập, ngược lại trả về false
        return false;
    }

}