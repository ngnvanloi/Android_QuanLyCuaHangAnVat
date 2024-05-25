package com.example.quanlycuahangbandoanvat.Config;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.quanlycuahangbandoanvat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class InitDatabase {
    private FirebaseFirestore firestore;
    private Context context;
    private static final String TAG = "InitDatabase";

    public InitDatabase(Context context) {
        this.context = context;
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void initData() {
        // Mảng này chứa các resource ID của tệp JSON trong res/raw
        int[] jsonFiles = {
                //R.raw.role,
                R.raw.bill,
                //R.raw.bill_detail,
                //R.raw.cart,
                //R.raw.cart_detail,
                //R.raw.category,
                //R.raw.customer,
                //R.raw.food,
                //R.raw.promotion,
                //R.raw.rating
        };

        for (int resourceId : jsonFiles) {
            importJsonToFirestore(resourceId, getCollectionNameFromResourceId(resourceId));
        }
    }

    private String readRawResource(int resourceId) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = context.getResources().openRawResource(resourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void importJsonToFirestore(int resourceId, String collectionName) {
        String jsonString = readRawResource(resourceId);
        if (jsonString == null || jsonString.isEmpty()) {
            Log.e(TAG, "JSON content is empty or null for resource: " + resourceId);
            return;
        }

        JsonElement jsonElement = JsonParser.parseString(jsonString);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            processJsonObjectData(collectionName, jsonObject);
        } else if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            processJsonArrayData(collectionName, jsonArray);
        }
    }

    private void processJsonObjectData(String collectionName, JsonObject jsonObject) {
        // Xử lý đối tượng JSON
        firestore.collection(collectionName).add(jsonObject)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }

    private void processJsonArrayData(String collectionName, JsonArray jsonArray) {
        // Xử lý mảng JSON
        List<JsonObject> dataList = new Gson().fromJson(jsonArray, new TypeToken<List<JsonObject>>(){}.getType());
        for (JsonObject jsonObject : dataList) {
            firestore.collection(collectionName).add(jsonObject)
                    .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
        }
    }

    private String getCollectionNameFromResourceId(int resourceId) {
        String fileName = context.getResources().getResourceEntryName(resourceId);
        return fileName;
    }
}
