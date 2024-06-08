package com.example.quanlycuahangbandoanvat.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quanlycuahangbandoanvat.DTO.Bill;
import com.example.quanlycuahangbandoanvat.R;

import java.util.ArrayList;


public class CustomAdapterRecycleViewOderBillTrue extends RecyclerView.Adapter<CustomAdapterRecycleViewOderBillTrue.ViewHolder> {

    private Context context;
    private ArrayList<Bill> listBill;

    public CustomAdapterRecycleViewOderBillTrue(Context context, ArrayList<Bill> listBill) {
        this.context = context;
        this.listBill = listBill;
    }

    @NonNull
    @Override
    public CustomAdapterRecycleViewOderBillTrue.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyitem_oder_istrue, parent, false);
        return new CustomAdapterRecycleViewOderBillTrue.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bill bill = listBill.get(position);
        holder.txtIdBillOder.setText(bill.getBill_ID());
        holder.txtDateOder.setText(String.valueOf(bill.getOrder_Date()));
        holder.txtBillStatus.setText(bill.getBill_Status());

        holder.imageBtnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listBill.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       public TextView txtIdBillOder,txtDateOder,txtBillStatus;
       ImageView imageBtnDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIdBillOder = itemView.findViewById(R.id.txtIDBill);
            txtDateOder = itemView.findViewById(R.id.txtOderDate);
            txtBillStatus = itemView.findViewById(R.id.txtBillStatus);
            imageBtnDetails = itemView.findViewById(R.id.imageBtnDetails);
        }
    }

}