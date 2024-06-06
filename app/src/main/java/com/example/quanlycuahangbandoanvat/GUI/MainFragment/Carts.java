package com.example.quanlycuahangbandoanvat.GUI.MainFragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlycuahangbandoanvat.Adapter.CustomAdapterListViewCart;
import com.example.quanlycuahangbandoanvat.BUS.CartBUS;
import com.example.quanlycuahangbandoanvat.BUS.CartDetailBUS;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackCart;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackCartDetail;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallbackPromotion;
import com.example.quanlycuahangbandoanvat.DAO.CartDAO;
import com.example.quanlycuahangbandoanvat.DAO.CartDetailDAO;
import com.example.quanlycuahangbandoanvat.DAO.PromotionDAO;
import com.example.quanlycuahangbandoanvat.DTO.Cart;
import com.example.quanlycuahangbandoanvat.DTO.CartDetail;
import com.example.quanlycuahangbandoanvat.DTO.Promotion;
import com.example.quanlycuahangbandoanvat.GUI.CartFragment.CartEmptyFragment;
import com.example.quanlycuahangbandoanvat.GUI.Interface.OnCartChangedListener;
import com.example.quanlycuahangbandoanvat.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Carts extends Fragment implements OnCartChangedListener {

    private RecyclerView recyclerViewListViewCart;
    private CartDetailDAO cartDetailDAO;
    private CartDAO cartDAO;
    private CustomAdapterListViewCart recyclerViewCartAdapter;
    private ArrayList<CartDetail> listCartDetail;

    private EditText edtMaGiamGia;
    private Button btnApplyPromotion, btnThanhToan;
    private TextView total_Oder, total_Payment, total_Delivery, total_Promotion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupRecyclerView();

        String cart_ID = getCartIDFromSharedPreferences();
        if (!cart_ID.isEmpty()) {
            loadCartDetails(cart_ID);
        } else {
            Toast.makeText(getContext(), "No cart found", Toast.LENGTH_SHORT).show();
        }

        addEvent();

    }

    private void initViews(View view) {
        recyclerViewListViewCart = view.findViewById(R.id.recyclerViewItemCart);
        edtMaGiamGia = view.findViewById(R.id.edtMaGiamGia);
        btnApplyPromotion = view.findViewById(R.id.btnApplyGiamGia);
        total_Oder = view.findViewById(R.id.txtTotalDHang);
        total_Payment = view.findViewById(R.id.txtTotalBill);
        total_Delivery = view.findViewById(R.id.txtPhiGHang);
        total_Promotion = view.findViewById(R.id.txtPromotion);
        btnThanhToan = view.findViewById(R.id.btnThanhToan);
    }

    private void addEvent() {
        btnApplyPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String promotion_ID = edtMaGiamGia.getText().toString();
                applyPromotion(promotion_ID);
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setupRecyclerView() {
        recyclerViewListViewCart.setLayoutManager(new LinearLayoutManager(getContext()));
        listCartDetail = new ArrayList<>();
        recyclerViewCartAdapter = new CustomAdapterListViewCart(getContext(), listCartDetail, this);
        recyclerViewListViewCart.setAdapter(recyclerViewCartAdapter);
    }

    private void loadCartDetails(String cart_ID) {
        cartDetailDAO = new CartDetailDAO();
        cartDetailDAO.selectAll(new OnDataLoadedCallbackCartDetail() {
            @Override
            public void onDataLoaded(ArrayList<CartDetail> cartDetails) {
                CartDetailBUS cartDetailBUS = new CartDetailBUS(cartDetails);
                listCartDetail.clear();
                listCartDetail.addAll(cartDetailBUS.getCartDetailByCart(cart_ID));
                if (listCartDetail.isEmpty()){
                    loadFragment(new CartEmptyFragment());
                }else{
                    recyclerViewCartAdapter.notifyDataSetChanged();
                    updateTotalPayment(cart_ID);
                }
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(getContext(), "Error loading cart details", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateTotalPayment(String cart_ID) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);

        cartDAO = new CartDAO();

        cartDAO.selectByIds(cart_ID, new OnDataLoadedCallbackCart() {
            @Override
            public void onDataLoaded(ArrayList<Cart> t) {

            }

            @Override
            public void onDataLoadedSigle(Cart cart) {
                if (cart != null) {
                    double deliveryFee = cart.getTotal_Cart() < 300000 ? 30000 : 0;

                    Handler mainHandler = new Handler(Looper.getMainLooper());
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            total_Oder.setText(numberFormat.format(cart.getTotal_Cart()));
                            total_Delivery.setText(numberFormat.format(deliveryFee));
                            String totalDeliveryText = total_Delivery.getText().toString();
                            totalDeliveryText = totalDeliveryText.replaceAll("[^0-9]", "");
                            double totalDelivery = Double.parseDouble(totalDeliveryText);
                            double totalPaymet = cart.getTotal_Cart() + totalDelivery;
                            total_Payment.setText(numberFormat.format(totalPaymet));
                        }
                    });
                } else {
                    Toast.makeText(getContext(), "Cart not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private void applyPromotion(String promotion_ID) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);

//        SharedPreferences sharedPref = requireActivity().getPreferences(MODE_PRIVATE);
//        String lastAppliedPromotionID = sharedPref.getString("last_applied_promotion", "");

        PromotionDAO promotionDAO = new PromotionDAO();

        // Sử dụng selectById() với callback để xử lý dữ liệu sau khi tải về
        promotionDAO.selectByIds(promotion_ID, new OnDataLoadedCallbackPromotion() {
            @Override
            public void onDataLoaded(ArrayList<Promotion> t) {

            }

            @Override
            public void onDataLoadedSingle(Promotion promotion) {
                if (promotion != null) {
                    String totalOrderText = total_Oder.getText().toString();
                    totalOrderText = totalOrderText.replaceAll("[^0-9]", "");
                    double totalOrder = Double.parseDouble(totalOrderText);

                    if (totalOrder < promotion.getTotal_min()) {
                        Toast.makeText(getContext(), "Tổng đơn hàng chưa đủ điều kiện áp dụng khuyến mãi !", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Kiểm tra khuyến mãi đã áp dụng
//                    if (!appliedPromotionID.isEmpty() && appliedPromotionID.equals(promotion_ID)) {
//                        Toast.makeText(getContext(), "Bạn đã áp dụng mã khuyến mãi này !", Toast.LENGTH_SHORT).show();
//                        return;
//                    }

//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putString("last_applied_promotion", promotion_ID);
//                    editor.apply();

                    double totalDelivery = Double.parseDouble(total_Delivery.getText().toString().replaceAll("[^0-9.]", ""));
                    double discountAmount = promotion.getDiscount_Amount();
                    double total_Payments = totalOrder - totalDelivery - discountAmount;
                    total_Promotion.setText(numberFormat.format(discountAmount));
                    total_Payment.setText(numberFormat.format(total_Payments));

                    Toast.makeText(getContext(), "Áp dụng khuyến mãi thành công !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Mã khuyến mãi không hợp lệ !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private String getCartIDFromSharedPreferences() {
        SharedPreferences sharedPref = requireActivity().getPreferences(MODE_PRIVATE);
        return sharedPref.getString("current_cart_id", "");
    }


    @Override
    public void onCartChanged() {
        String cart_ID = getCartIDFromSharedPreferences();
        if (!cart_ID.isEmpty()) {
            updateTotalPayment(cart_ID);
        } else {
            Toast.makeText(getContext(), "Cart ID not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayoutMainActivity, fragment);
        fragmentTransaction.commit();
    }
}
