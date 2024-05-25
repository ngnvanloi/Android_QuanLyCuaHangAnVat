package com.example.quanlycuahangbandoanvat.GUI.MenuFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlycuahangbandoanvat.R;


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}