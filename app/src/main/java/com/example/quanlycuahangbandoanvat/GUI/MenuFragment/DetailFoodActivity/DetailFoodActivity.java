package com.example.quanlycuahangbandoanvat.GUI.MenuFragment.DetailFoodActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quanlycuahangbandoanvat.DTO.Food;
import com.example.quanlycuahangbandoanvat.Helper.Formatter;
import com.example.quanlycuahangbandoanvat.R;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DetailFoodActivity extends AppCompatActivity {

    private ImageView imageView_Back,imgdetailfood;

    private TextView namedetailfood, pricedetailfood, motadetail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        // Gắn ID
        imageView_Back = findViewById(R.id.imageView_Back);
       imgdetailfood=findViewById(R.id.imgdetailfood);
        namedetailfood = findViewById(R.id.namedetailfood);
        pricedetailfood = findViewById(R.id.pricedetailfood);
        motadetail = findViewById(R.id.motadetail);

        // Lấy thông tin chi tiết của Food
        Intent intent = getIntent();
        Food selectedFood = (Food) intent.getSerializableExtra("SelectedFood");
        if (selectedFood != null) {
            namedetailfood.setText(selectedFood.getFood_Name());
            String priceFormat = Formatter.FormatVND(selectedFood.getFood_Price());
            pricedetailfood.setText(priceFormat);
            motadetail.setText(selectedFood.getFood_Description());
            String urlImage = selectedFood.getFood_Image();

            Glide.with(DetailFoodActivity.this)
                    .load(urlImage)
                    .placeholder(R.drawable.logokfc3)
                    .error(R.drawable.image_error)
                    .into(imgdetailfood);
        }
        // Sự kiện click vào nút back để quay lại trang trước
        imageView_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}