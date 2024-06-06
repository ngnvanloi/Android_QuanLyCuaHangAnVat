package com.example.quanlycuahangbandoanvat.Adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.quanlycuahangbandoanvat.BUS.CartBUS;
import com.example.quanlycuahangbandoanvat.BUS.CartDetailBUS;
import com.example.quanlycuahangbandoanvat.DAO.Callback.CRUDCallback;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackCartDetail;
import com.example.quanlycuahangbandoanvat.DAO.CartDAO;
import com.example.quanlycuahangbandoanvat.DAO.CartDetailDAO;
import com.example.quanlycuahangbandoanvat.DTO.Cart;
import com.example.quanlycuahangbandoanvat.DTO.CartDetail;
import com.example.quanlycuahangbandoanvat.DTO.Food;
import com.example.quanlycuahangbandoanvat.Helper.Formatter;
import com.example.quanlycuahangbandoanvat.R;

import java.util.ArrayList;

public class CustomAdapterListViewFood extends ArrayAdapter<Food> {
    Context context;
    int layoutItem;
    ArrayList<Food> listFood;
    CartBUS cartBUS = new CartBUS();
    CartDetailBUS cartDetailBUS = new CartDetailBUS();
    CartDAO cartDAO = new CartDAO();
    CartDetailDAO cartDetailDAO = new CartDetailDAO();

    public CustomAdapterListViewFood(@NonNull Context context, int layoutItem, @NonNull ArrayList<Food> listFood) {
        super(context, layoutItem, listFood);
        this.context = context;
        this.layoutItem = layoutItem;
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Food food = listFood.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutItem, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imgFood);
        String urlImage = food.getFood_Image();

        Glide.with(getContext())
                .load(urlImage)
                .placeholder(R.drawable.logokfc3)
                .error(R.drawable.image_error)
                .into(imageView);

        TextView tvName = convertView.findViewById(R.id.tvFoodName);
        tvName.setText(food.getFood_Name());

        TextView tvPrice = convertView.findViewById(R.id.tvFoodPrice);
        String priceFormat = Formatter.FormatVND(food.getFood_Price());
        tvPrice.setText(priceFormat);

        TextView tvDes = convertView.findViewById(R.id.tvFoodDescription);
        tvDes.setText(String.valueOf(food.getFood_Description()));

        Button btnAddFoodToCart = convertView.findViewById(R.id.btnFoodAddToCart);

        btnAddFoodToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentCartID = getCartIDFromSharedReferences();
                String currentCusID = getCustomerIDFromSharedReferences();
                cartDetailDAO.selectAll(new OnDataLoadedCallbackCartDetail() {
                    @Override
                    public void onDataLoaded(ArrayList<CartDetail> t) {
                        cartDetailBUS = new CartDetailBUS(t);
                        CartDetail existingCartDetail = cartDetailBUS.getCartDetailByFoodID(currentCartID, food.getFood_ID());
                        if (existingCartDetail == null) {
                            int defaultQuantity = 1;
                            CartDetail newCartDetail = new CartDetail(null, currentCartID, food.getFood_ID(), defaultQuantity, food.getFood_Price());
                            cartDetailDAO.insert(newCartDetail, new CRUDCallback() {
                                @Override
                                public void onCRUDComplete(int result) {
                                    if (result == 1) {
                                        updateCartTotal(currentCartID, currentCusID);
                                        Toast.makeText(getContext(), "Đã thêm " + food.getFood_Name() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "Thêm vào giỏ hàng thất bại", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            int newQuantity = existingCartDetail.getQuantity() + 1;
                            existingCartDetail.setQuantity(newQuantity);
                            existingCartDetail.setPrice(newQuantity * food.getFood_Price());
                            cartDetailDAO.update(existingCartDetail, new CRUDCallback() {
                                @Override
                                public void onCRUDComplete(int result) {
                                    if (result == 1) {
                                        updateCartTotal(currentCartID, currentCusID);
                                        Toast.makeText(getContext(), "Đã cập nhật số lượng " + food.getFood_Name() + " trong giỏ hàng", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "Cập nhật số lượng thất bại", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                    @Override
                    public void onError(String errorMessage) {
                        // Xử lý lỗi
                        Toast.makeText(getContext(), "Lỗi tải dữ liệu giỏ hàng", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return convertView;
    }

    private void updateCartTotal(String cartID, String customerID) {
        cartDetailDAO.selectAllByCartID(cartID, new OnDataLoadedCallbackCartDetail() {
            @Override
            public void onDataLoaded(ArrayList<CartDetail> cartDetails) {
                double totalCartPrice = 0;
                for (CartDetail cartDetail : cartDetails) {
                    totalCartPrice += cartDetail.getPrice();
                }
                Cart cart = new Cart(cartID, customerID, totalCartPrice);
                cartDAO.update(cart, new CRUDCallback() {
                    @Override
                    public void onCRUDComplete(int result) {
                        if (result == 1) {

                        } else {

                        }
                    }
                });
            }

            @Override
            public void onError(String errorMessage) {
                // Xử lý lỗi
                Toast.makeText(context, "Lỗi khi tính tổng tiền giỏ hàng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getCustomerIDFromSharedReferences() {
        SharedPreferences sharedPref = this.context.getSharedPreferences("GUI.MainActivity", Context.MODE_PRIVATE);
        return sharedPref.getString("current_customer_id", "");
    }

    private String getCartIDFromSharedReferences() {
        SharedPreferences sharedPref = this.context.getSharedPreferences("GUI.MainActivity", MODE_PRIVATE);
        return sharedPref.getString("current_cart_id", "");
    }
}
