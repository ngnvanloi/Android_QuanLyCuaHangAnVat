package com.example.quanlycuahangbandoanvat.BUS;

import com.example.quanlycuahangbandoanvat.DTO.Food;

import java.util.ArrayList;

public class FoodBUS {
    private ArrayList<Food> listFood = new ArrayList<>();

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    public FoodBUS(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    public FoodBUS() {

    }
    public ArrayList<Food> getAll() {
        return this.listFood;
    }

    public ArrayList<Food> getFoodByCategory(String category_ID) {
        ArrayList<Food> result = new ArrayList<>();
        for(Food food : this.listFood) {
            if(food.getFood_Category_ID().equals(category_ID)) {
                result.add(food);
            }
        }
        return result;
    }

    public Food getByIndex(int index) {
        return this.listFood.get(index);
    }

    public Food getByFoodID(String id) {
        int vitri = -1;
        int i = 0;
        while (i <= this.listFood.size() && vitri == -1) {
            if (this.listFood.get(i).getFood_ID().equals(id)) {
                vitri = i;
            } else {
                i++;
            }
        }
        return this.listFood.get(vitri);
    }

    public int getIndexByFoodID(String id) {
        int i = 0;
        int vitri = -1;
        while (i < this.listFood.size() && vitri == -1) {
            if (listFood.get(i).getFood_ID().equals(id)) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public ArrayList<Food> search(String text) {
        text = text.toLowerCase();
        ArrayList<Food> result = new ArrayList<>();
        for (Food i : this.listFood) {
            if (i.getFood_Name().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }
}
