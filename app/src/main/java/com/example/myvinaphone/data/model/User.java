package com.example.myvinaphone.data.model;

public class User {
    private String mUsername;
    private String mPassword;
    private String mFullName;


    public User(String mUsername, String mPassword, String mFullName) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mFullName = mFullName;
    }

    public User(String mUsername, String mPassword) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }
}
