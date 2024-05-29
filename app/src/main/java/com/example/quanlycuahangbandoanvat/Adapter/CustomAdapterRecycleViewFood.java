package com.example.quanlycuahangbandoanvat.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quanlycuahangbandoanvat.DTO.Food;
import com.example.quanlycuahangbandoanvat.R;

import java.util.ArrayList;

public class CustomAdapterRecycleViewFood extends RecyclerView.Adapter<CustomAdapterRecycleViewFood.MyViewHolder>{
    ArrayList<Food> arrayListFood = new ArrayList<>();

    // nhận dữ liệu
    public CustomAdapterRecycleViewFood(ArrayList<Food> arrayListFood) {
        this.arrayListFood = arrayListFood;
    }


    // Phương thức này được gọi khi RecyclerView cần một ViewHolder mới của mục.
    // Nó tạo một View mới bằng cách inflate layout từ file xml (layout_item_movie) và trả về một ViewHolder mới chứa View này.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_food_horizontal_item,
                parent,false);
        return new MyViewHolder(itemView);
    }

    // Phương thức này được gọi khi RecyclerView cần hiển thị dữ liệu tại vị trí cụ thể.
    // Nó lấy dữ liệu từ đối tượng Movie ứng với vị trí trong danh sách và gán dữ liệu này cho các TextView trong ViewHolder.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = arrayListFood.get(position);
        holder.tvName.setText(food.getFood_Name());
        holder.tvPrice.setText(String.valueOf(food.getFood_Price()));
        holder.tvDes.setText(String.valueOf(food.getFood_Description()));
        //holder.imageViewFood.setImageResource(food.getFood_Image());

        String urlImage = food.getFood_Image();

        Glide.with(holder.itemView.getContext())
                .load(urlImage)
                .placeholder(R.drawable.logokfc3) // Hình ảnh hiển thị trong khi tải
                .error(R.drawable.image_error) // Hình ảnh hiển thị nếu tải thất bại
                .into(holder.imageViewFood);
    }

    @Override
    public int getItemCount() {
        return arrayListFood.size();
    }

    // đại diện cho mỗi mục trong RecyclerView.
    // Nó giữ các tham chiếu đến các thành phần giao diện người dùng (cụ thể là các TextView) được hiển thị cho mỗi mục.
    // Đối với mỗi ViewHolder, nó sẽ được khởi tạo với các TextView tương ứng từ layout_item_movie.
    public  class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvPrice, tvDes;
        ImageView imageViewFood;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvHorFoodName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvHorFoodPrice);
            tvDes = (TextView) itemView.findViewById(R.id.tvHorFoodDescription);
            imageViewFood =(ImageView) itemView.findViewById(R.id.imgHorFood);
        }
    }
}

