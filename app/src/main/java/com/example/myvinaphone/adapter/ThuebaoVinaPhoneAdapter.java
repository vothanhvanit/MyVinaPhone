package com.example.myvinaphone.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myvinaphone.R;
import com.example.myvinaphone.data.model.ThuebaoVinaPhone;

import java.util.List;

public class ThuebaoVinaPhoneAdapter extends ArrayAdapter<ThuebaoVinaPhone> {
    Activity context;
    int resource;
    List<ThuebaoVinaPhone> objects;

    public ThuebaoVinaPhoneAdapter(@NonNull Activity context, int resource, @NonNull List<ThuebaoVinaPhone> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView  = LayoutInflater.from(this.context).inflate(R.layout.item_tkc_balance, parent,false);
        TextView tv_stt = convertView.findViewById(R.id.tv_stt);
        TextView tv_sdt = convertView.findViewById(R.id.tv_sdt);
        TextView tv_balance_tkc = convertView.findViewById(R.id.tv_balance_tkc);

        ThuebaoVinaPhone iThuebao = objects.get(position);
        tv_stt.setText(( position + 1 +""  ));
        tv_sdt.setText(iThuebao.getSdt());
        tv_balance_tkc.setText(iThuebao.getSoDuTKC() + "");


        return convertView;
    }
}
