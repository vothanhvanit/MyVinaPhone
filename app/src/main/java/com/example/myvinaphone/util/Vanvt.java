package com.example.myvinaphone.util;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public  class Vanvt {
    ///Lấy dữ liệu Json từ Internet

    public static JSONArray getJsonOjbects(String url_address) throws Exception {
        JSONArray jsonArray = null;
        try {
        URL url = new URL(url_address);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String line  = bufferedReader.readLine();

        while(line!=null) {
            builder.append(line);
            line =  bufferedReader.readLine();
        }

         jsonArray = new JSONArray(builder.toString());
        return jsonArray;
        }
        catch (Exception ex) {
            throw ex;
        }

    }
}
