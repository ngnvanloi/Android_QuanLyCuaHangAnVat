package com.example.quanlycuahangbandoanvat.GUI.MenuFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quanlycuahangbandoanvat.Adapter.CustomAdapterListViewFood;
import com.example.quanlycuahangbandoanvat.Adapter.CustomAdapterListViewFood;
import com.example.quanlycuahangbandoanvat.BUS.FoodBUS;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallback;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackFood;
import com.example.quanlycuahangbandoanvat.DAO.FoodDAO;
import com.example.quanlycuahangbandoanvat.DTO.Food;
import com.example.quanlycuahangbandoanvat.GUI.MainDemoFirebase;
import com.example.quanlycuahangbandoanvat.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllFood_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllFood_Fragment extends Fragment {


    public AllFood_Fragment() {
        // Required empty public constructor
    }
    public static AllFood_Fragment newInstance(String param1, String param2) {
        AllFood_Fragment fragment = new AllFood_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_food, container, false);
    }

    // khai báo biến
    ListView listViewAllFood;
    FoodBUS foodBUS = new FoodBUS();
    CustomAdapterListViewFood customAdapterFood;
    FoodDAO foodDAO = new FoodDAO();
    ArrayList<Food> listFood = new ArrayList<>();
    TextView tv;

    int selectedPosition = -1;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ánh xạ ID
        listViewAllFood = (view).findViewById(R.id.listViewAllFood);


        // innit array list Food
        foodDAO.selectAll(new OnDataLoadedCallbackFood() {
            @Override
            public void onDataLoaded(ArrayList<Food> Foods) {
                listFood.addAll(Foods);
                // init list view
                customAdapterFood = new CustomAdapterListViewFood(getContext(), R.layout.layout_food_item, listFood);
                listViewAllFood.setAdapter(customAdapterFood);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });

        // init list view
//        loadArrayListFood();
//        customAdapterFood = new CustomAdapterListViewFood(getContext(), R.layout.layout_food_item, listFood);
//        listViewAllFood.setAdapter(customAdapterFood);
    }

    public void loadArrayListFood(){
        foodDAO.selectAll(new OnDataLoadedCallbackFood() {
            @Override
            public void onDataLoaded(ArrayList<Food> Foods) {
                listFood.clear();
                listFood.addAll(Foods);
                customAdapterFood.notifyDataSetChanged();
                foodBUS.setListFood(listFood);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }
}