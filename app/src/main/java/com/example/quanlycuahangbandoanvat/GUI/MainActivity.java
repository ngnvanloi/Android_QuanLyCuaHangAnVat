package com.example.quanlycuahangbandoanvat.GUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.quanlycuahangbandoanvat.DTO.Customer;
import com.example.quanlycuahangbandoanvat.DTO.CustomerViewModel;
import com.example.quanlycuahangbandoanvat.GUI.CartFragment.CartEmptyFragment;
import com.example.quanlycuahangbandoanvat.GUI.Interface.OnCartChangedListener;
import com.example.quanlycuahangbandoanvat.GUI.Interface.OnNavigationLinkClickListener;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Account;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Carts;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Home;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Location;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Login;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Menu;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.NoLoginCart;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Option;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Register;
import com.example.quanlycuahangbandoanvat.GUI.MainFragment.Voucher;
import com.example.quanlycuahangbandoanvat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OnNavigationLinkClickListener, OnCartChangedListener {
    private BottomNavigationView bottomNavigationView;
    private ImageView imageViewAccountNavigation, imageViewHomeNavigation, imageViewOptionNavigation;
    private FrameLayout frameLayoutMainActivity;
    private Toolbar toolbar;
    private CustomerViewModel customerViewModel;
    private Boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View Binding
        bottomNavigationView = findViewById(R.id.BottomNavigation);
        frameLayoutMainActivity = findViewById(R.id.FrameLayoutMainActivity);
        imageViewHomeNavigation = findViewById(R.id.imageViewHomeNavigation);
        imageViewAccountNavigation = findViewById(R.id.imageViewAccountNavigation);
        imageViewOptionNavigation = findViewById(R.id.imageViewOptionNavigation);
        toolbar = findViewById(R.id.toolbar);

        // Customer ViewModel
        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);

        // Default Fragment
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        // Top Navigation Item Listeners
        imageViewHomeNavigation.setOnClickListener(v -> loadFragment(new Home()));
        imageViewAccountNavigation.setOnClickListener(v -> {
            if (isUserLoggedIn()) {
                loadFragment(new Account());
            } else {
                loadFragment(new Register());
            }
        });
        imageViewOptionNavigation.setOnClickListener(v -> loadFragment(new Option()));

        // Bottom Navigation Item Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(new Home());
                    break;
                case R.id.navigation_voucher:
                    loadFragment(new Voucher());
                    break;
                case R.id.navigation_cart:
                    if (isUserLoggedIn()) {
                        loadFragment(new Carts());
                    } else {
                        loadFragment(new NoLoginCart());
                    }
                    break;
                case R.id.navigation_menu:
                    loadFragment(new Menu());
                    break;
                case R.id.navigation_location:
                    loadFragment(new Location());
                    break;
                default:
                    return false;
            }
            return true;
        });

        // Load the default Home fragment
        loadFragment(new Home());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayoutMainActivity, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onRegisterLinkClicked() {
        loadFragment(new Register());
    }

    @Override
    public void onLoginLinkClicked() {
        loadFragment(new Login());
    }

    public void onRegisterLinkClick(View view) {
        loadFragment(new Register());
    }

    public void onLoginLinkClick(View view) {
        loadFragment(new Login());
    }

    private boolean isUserLoggedIn() {
        String currentCustomerID = getCustomerIDFromSharedPreferences();
        Customer customer = customerViewModel.getCustomer().getValue();
        return !currentCustomerID.isEmpty() || customer != null;
    }

    private String getCustomerIDFromSharedPreferences() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString("current_customer_id", "");
    }

    @Override
    public void onCartChanged() {

    }
}
