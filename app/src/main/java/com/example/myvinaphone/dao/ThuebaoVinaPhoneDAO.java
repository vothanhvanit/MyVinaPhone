package com.example.myvinaphone.dao;

import android.util.Log;

import com.example.myvinaphone.data.model.ThuebaoVinaPhone;
import com.example.myvinaphone.util.Vanvt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ThuebaoVinaPhoneDAO {

    //Tìm số điện thoại
    public List<ThuebaoVinaPhone> findbysdt(String sdt) {
        List<ThuebaoVinaPhone> result = new ArrayList<>();
        //Địa chỉ URL lấy Kết quả Json được trả về từ webservices
        String address = "http://123.30.236.79/vinaphonebinhthuan_api/subscribers/" + sdt;
        try {
            JSONArray jSonArray = Vanvt.getJsonOjbects(address);

            for (int i = 0; i < jSonArray.length(); i++) {
                JSONObject jsonOject = jSonArray.getJSONObject(i);
                ThuebaoVinaPhone thuebao = new ThuebaoVinaPhone();

                if (jsonOject.has("Mobile")) {
                    thuebao.setSdt(jsonOject.getString("Mobile"));
                }

                if (jsonOject.has("Tkc_bal")) {
                    thuebao.setSoDuTKC(jsonOject.getInt("Tkc_bal"));
                }

                result.add(thuebao);
            }

        } catch (Exception ex) {

        }

        return result;
    }
}
