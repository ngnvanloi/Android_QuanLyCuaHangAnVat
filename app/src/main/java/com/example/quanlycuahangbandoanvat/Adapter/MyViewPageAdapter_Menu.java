package com.example.quanlycuahangbandoanvat.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlycuahangbandoanvat.GUI.MenuFragment.AllFood_Fragment;
import com.example.quanlycuahangbandoanvat.GUI.MenuFragment.ChickenFried_Fragment;
import com.example.quanlycuahangbandoanvat.GUI.MenuFragment.Combo1_Fragment;
import com.example.quanlycuahangbandoanvat.GUI.MenuFragment.Combo2_Fragment;
import com.example.quanlycuahangbandoanvat.GUI.MenuFragment.Combo3_Fragment;

public class MyViewPageAdapter_Menu extends  FragmentStatePagerAdapter{
    public MyViewPageAdapter_Menu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new AllFood_Fragment();
            case 1:
                return  new Combo1_Fragment();
            case 2:
                return  new Combo2_Fragment();
            case 3:
                return new Combo3_Fragment();
            case 4:
                return new ChickenFried_Fragment();
            default: return new AllFood_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0:
               return "Tất cả";
           case  1:
               return "Combo 1 người";
           case 2:
               return "Combo nhóm";
           case 3:
               return "Burger - Cơm - Mì Ý";
           case 4:
               return "Gà rán";
           default:
               return "Tất cả";
       }
    }

}
