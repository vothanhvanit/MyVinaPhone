package com.example.myvinaphone.data.model;

import java.io.Serializable;

public class ThuebaoVinaPhone implements Serializable {
    private String Sdt;
    private int SoDuTKC; //Số dư Tài khoảng
    private int tkc_n;//Tiêu dùng TKC tháng hiện tại (chưa hết tháng)
    private int tkc_n_1;//Tiêu dùng cách 1 tháng
    private int tkc_n_2;//Tiêu dùng cách 2 tháng
    private int tkc_n_3;//Tiêu dùng cách 2 tháng
    private int tkc_average; //Tiêu dùng TKC trung bình 3 tháng gần nhất (Tháng 1, 2, 3)
    private int mTotal_data; //Tiêu dùng data tháng hiện tại
    private String mSmartphone;
    private String mAddress;
    private String mGoiRecommend;//Gói cước đề xuất đăng ký
    private String mGoi_cuoc;//Danh sách gói cước đang dùng


    public ThuebaoVinaPhone(String sdt, int soDuTKC, int tkc_n, int tkc_n_1, int tkc_n_2, int tkc_n_3, int tkc_average, int mTotal_data, String mSmartphone, String mAddress, String mGoiRecommend, String mGoi_cuoc) {
        Sdt = sdt;
        SoDuTKC = soDuTKC;
        this.tkc_n = tkc_n;
        this.tkc_n_1 = tkc_n_1;
        this.tkc_n_2 = tkc_n_2;
        this.tkc_n_3 = tkc_n_3;
        this.tkc_average = tkc_average;
        this.mTotal_data = mTotal_data;
        this.mSmartphone = mSmartphone;
        this.mAddress = mAddress;
        this.mGoiRecommend = mGoiRecommend;
        this.mGoi_cuoc = mGoi_cuoc;
    }

    public ThuebaoVinaPhone() {
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public int getSoDuTKC() {
        return SoDuTKC;
    }

    public void setSoDuTKC(int soDuTKC) {
        SoDuTKC = soDuTKC;
    }

    public int getTkc_n() {
        return tkc_n;
    }

    public void setTkc_n(int tkc_n) {
        this.tkc_n = tkc_n;
    }

    public int getTkc_n_1() {
        return tkc_n_1;
    }

    public void setTkc_n_1(int tkc_n_1) {
        this.tkc_n_1 = tkc_n_1;
    }

    public int getTkc_n_2() {
        return tkc_n_2;
    }

    public void setTkc_n_2(int tkc_n_2) {
        this.tkc_n_2 = tkc_n_2;
    }

    public int getTkc_n_3() {
        return tkc_n_3;
    }

    public void setTkc_n_3(int tkc_n_3) {
        this.tkc_n_3 = tkc_n_3;
    }

    public int getTkc_average() {
        return tkc_average;
    }

    public void setTkc_average(int tkc_average) {
        this.tkc_average = tkc_average;
    }

    public int getmTotal_data() {
        return mTotal_data;
    }

    public void setmTotal_data(int mTotal_data) {
        this.mTotal_data = mTotal_data;
    }

    public String getmSmartphone() {
        return mSmartphone;
    }

    public void setmSmartphone(String mSmartphone) {
        this.mSmartphone = mSmartphone;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmGoiRecommend() {
        return mGoiRecommend;
    }

    public void setmGoiRecommend(String mGoiRecommend) {
        this.mGoiRecommend = mGoiRecommend;
    }

    public String getmGoi_cuoc() {
        return mGoi_cuoc;
    }

    public void setmGoi_cuoc(String mGoi_cuoc) {
        this.mGoi_cuoc = mGoi_cuoc;
    }
}
