package com.example.myvinaphone.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myvinaphone.data.model.User;

public class SessionManagement {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String SHARED_PREF_NAME="session";
    private String SESSION_KEY = "session_user";

    public SessionManagement(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void saveSession(User user) {
        String username = user.getmUsername();
        this.editor.putString(SESSION_KEY, username).commit();
    }

    public String getSession() {
        return sharedPreferences.getString(SESSION_KEY, "");
    }

    public void removeSession() {
        this.editor.putString(SESSION_KEY, "").commit();
    }

}
