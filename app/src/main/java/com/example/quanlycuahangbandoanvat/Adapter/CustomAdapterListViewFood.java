package com.example.quanlycuahangbandoanvat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.quanlycuahangbandoanvat.DTO.Food;
import com.example.quanlycuahangbandoanvat.Helper.Formatter;
import com.example.quanlycuahangbandoanvat.R;

import java.util.ArrayList;

public class CustomAdapterListViewFood extends ArrayAdapter {
    Context context; // ngữ cảnh
    int layoutItem; // layout item
    ArrayList<Food> listFood = new ArrayList<>(); // dữ liệu


    public CustomAdapterListViewFood(@NonNull Context context, int layoutItem, @NonNull  ArrayList<Food> listFood) {
        super(context, layoutItem, listFood);
        this.context=context;
        this.layoutItem = layoutItem;
        this.listFood=listFood;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Food Food = listFood.get(position);

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgFood);
        String urlImage = Food.getFood_Image();

        Glide.with(getContext())
                .load(urlImage)
                .placeholder(R.drawable.logokfc3) // Hình ảnh hiển thị trong khi tải
                .error(R.drawable.image_error) // Hình ảnh hiển thị nếu tải thất bại
                .into(imageView);


        TextView tvName = (TextView) convertView.findViewById(R.id.tvFoodName);
        tvName.setText(Food.getFood_Name());

        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvFoodPrice);
        String priceFormat = Formatter.FormatVND(Food.getFood_Price());
        tvPrice.setText(priceFormat);

        TextView tvDes = (TextView) convertView.findViewById(R.id.tvFoodDescription);
        tvDes.setText(String.valueOf(Food.getFood_Description()));

        return convertView;
    }
}
