package com.example.quanlycuahangbandoanvat.DAO;


import com.example.quanlycuahangbandoanvat.DAO.Callback.CRUDCallback;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallback;
import com.example.quanlycuahangbandoanvat.DTO.Food;

import java.util.ArrayList;

public class FoodDAO implements DAOinterface<Food>{

    @Override
    public void insert(Food food, final CRUDCallback callback) {

    }

    @Override
    public void update(Food food, final CRUDCallback callback) {

    }

    @Override
    public void delete(String t, final CRUDCallback callback) {

    }

    @Override
    public ArrayList<Food> selectAll(final OnDataLoadedCallback listener) {
        return null;
    }

    @Override
    public Food selectById(String t) {
        return null;
    }
}
