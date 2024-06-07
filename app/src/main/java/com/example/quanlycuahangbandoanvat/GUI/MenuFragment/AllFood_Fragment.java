package com.example.quanlycuahangbandoanvat.GUI.MenuFragment;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
    EditText edt_search;
    FoodBUS foodBUS = new FoodBUS();
    CustomAdapterListViewFood customAdapterFood;
    FoodDAO foodDAO = new FoodDAO();
    ArrayList<Food> listFood = new ArrayList<>();
    private ArrayList<Food> originalListFood = new ArrayList<>();
    TextView tv;

    int selectedPosition = -1;
    private Runnable searchRunnable;
    private Handler handler = new Handler();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Ánh xạ ID
        listViewAllFood = view.findViewById(R.id.listViewAllFood);
        edt_search = view.findViewById(R.id.timkiemmonan);

        // Init array list Food
        foodDAO.selectAll(new OnDataLoadedCallbackFood() {
            @Override
            public void onDataLoaded(ArrayList<Food> Foods) {
                foodBUS = new FoodBUS(Foods);
                customAdapterFood = new CustomAdapterListViewFood(getContext(), R.layout.layout_food_item, Foods);
                listViewAllFood.setAdapter(customAdapterFood);

                // Tìm kiếm món ăn
                // Lắng nghe sự thay đổi của EditText
                edt_search.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // Không cần xử lý trước khi văn bản thay đổi
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Hủy bỏ runnable trước đó nếu người dùng tiếp tục nhập văn bản
                        if (searchRunnable != null) {
                            handler.removeCallbacks(searchRunnable);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        // Tạo một runnable để thực hiện tìm kiếm sau một khoảng thời gian ngắn
                        searchRunnable = new Runnable() {
                            @Override
                            public void run() {
                                String query = s.toString();
                                listFood = foodBUS.search(query);
                                customAdapterFood = new CustomAdapterListViewFood(getContext(), R.layout.layout_food_item, listFood);
                                listViewAllFood.setAdapter(customAdapterFood);
                                customAdapterFood.notifyDataSetChanged();
                            }
                        };
                        // Thực hiện runnable sau 1-2 giây (1000-2000 milliseconds)
                        handler.postDelayed(searchRunnable, 1000); // 1500 milliseconds = 1.5 giây
                    }
                });
            }

            @Override
            public void onError(String errorMessage) {
                // Xử lý lỗi nếu có
            }
        });
    }

    // Hàm cập nhật ListView với kết quả tìm kiếm
    private void updateListView(ArrayList<Food> searchResults) {
        listFood.clear();
        listFood.addAll(searchResults);
        customAdapterFood.notifyDataSetChanged();
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