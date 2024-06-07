package com.example.quanlycuahangbandoanvat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlycuahangbandoanvat.DTO.Notification;
import com.example.quanlycuahangbandoanvat.R;

import java.util.ArrayList;

public class CustomAdapterFragmentNotification extends ArrayAdapter {
    Context context; // ngữ cảnh
    int layoutItem; // layout item
    ArrayList<Notification> listNotification = new ArrayList<>(); // dữ liệu


    public CustomAdapterFragmentNotification(@NonNull Context context, int layoutItem, @NonNull  ArrayList<Notification> listNotification) {
        super(context, layoutItem, listNotification);
        this.context=context;
        this.layoutItem = layoutItem;
        this.listNotification=listNotification;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Notification notification = listNotification.get(position);

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }

        TextView tvNotificationContent = (TextView) convertView.findViewById(R.id.tvNotificationContent);
        tvNotificationContent.setText(notification.getNotification_Content());

        TextView tvNotificationTimeAgo = (TextView) convertView.findViewById(R.id.tvNotificationTimeAgo);
        long millisecondsUntilEnd = System.currentTimeMillis() - notification.getNotification_Date().getTime();
        int hours = (int) (millisecondsUntilEnd / (1000.0 * 3600.0));
        tvNotificationTimeAgo.setText(String.valueOf(hours) + " hours ago");

        String status;
        if(notification.getNotification_Status() == true){
            status = "Seen";
        }
        else {
            status = "Unnoticed";
        }
        TextView tvNotificationStatus = (TextView) convertView.findViewById(R.id.tvNotificationStatus);
        tvNotificationStatus.setText(status);

        return convertView;
    }
}
