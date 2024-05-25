package com.example.quanlycuahangbandoanvat.BUS;

import android.widget.Toast;

import com.example.quanlycuahangbandoanvat.DAO.Callback.CRUDCallback;
import com.example.quanlycuahangbandoanvat.DAO.Callback.OnDataLoadedCallback;
import com.example.quanlycuahangbandoanvat.DAO.UserDAO;
import com.example.quanlycuahangbandoanvat.DTO.User;

import java.util.ArrayList;

public class UserBUS {

//    public final UserDAO userDAO = new UserDAO();
    private ArrayList<User> listUser = new ArrayList<>();

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public UserBUS(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public UserBUS() {
//        userDAO.selectAll(new OnDataLoadedCallback() {
//            @Override
//            public void onDataLoaded(ArrayList<User> users) {
//                listUser.addAll(users);
//            }
//
//            @Override
//            public void onError(String errorMessage) {
//
//            }
//        });
    }
    public ArrayList<User> getAll() {
        return this.listUser;
    }


    public User getByIndex(int index) {
        return this.listUser.get(index);
    }

    public User getByUserID(String id) {
        int vitri = -1;
        int i = 0;
        while (i <= this.listUser.size() && vitri == -1) {
            if (this.listUser.get(i).getId().equals(id)) {
                vitri = i;
            } else {
                i++;
            }
        }
        return this.listUser.get(vitri);
    }
//    public boolean add(User user) {
//        final boolean[] check = new boolean[1];
//        userDAO.insert(user, new CRUDCallback() {
//            @Override
//            public void onCRUDComplete(int result) { // result = 1 / 0
//                if(result == 1) {
//                    check[0] = true;
//                    listUser.add(user);
//                }
//                else {
//                    check[0] = false;
//                }
//            }
//        });
//        return check[0];
//    }
    public int getIndexByUserID(String id) {
        int i = 0;
        int vitri = -1;
        while (i < this.listUser.size() && vitri == -1) {
            if (listUser.get(i).getId().equals(id)) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

//    public boolean delete(String id) {
//        final boolean[] check = {true};
//        User user = getByUserID(id);
//        userDAO.delete(id, new CRUDCallback() {
//            @Override
//            public void onCRUDComplete(int result) { // 1 / 0
//                if(result == 1) {
//                    check[0] = true;
//                    listUser.remove(user);
//                }
//                else {
//                    check[0] = false;
//                }
//            }
//        });
//        return check[0];
//    }

//    public Boolean update(User lh) {
//        final boolean[] check = {true};
//        userDAO.update(lh, new CRUDCallback() {
//            @Override
//            public void onCRUDComplete(int result) {
//                if(result == 1) {
//                    check[0] = true;
//                }
//                else {
//                    check[0] = false;
//                }
//            }
//        });
//        if (check[0]) {
//            this.listUser.set(getIndexByUserID(lh.getId()), lh);
//        }
//        return check[0];
//    }

    public ArrayList<User> search(String text) {
        text = text.toLowerCase();
        ArrayList<User> result = new ArrayList<>();
        for (User i : this.listUser) {
            if (i.getName().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }
}
