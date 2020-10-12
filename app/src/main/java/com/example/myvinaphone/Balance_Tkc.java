package com.example.myvinaphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myvinaphone.adapter.ThuebaoVinaPhoneAdapter;
import com.example.myvinaphone.dao.LogDao;
import com.example.myvinaphone.dao.ThuebaoVinaPhoneDAO;
import com.example.myvinaphone.data.model.ThuebaoVinaPhone;
import com.example.myvinaphone.util.SessionManagement;
import com.example.myvinaphone.util.Vanvt;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Balance_Tkc extends AppCompatActivity {

    Button btn_balance;
    EditText edt_sodt_vina;
    ListView lv_vina;

    List<ThuebaoVinaPhone> danhsachThuebao = new ArrayList<ThuebaoVinaPhone>();
    ThuebaoVinaPhoneAdapter thuebaoAdapter;
    String username;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance__tkc);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findSdt();
            }
        });
    }

    private void findSdt() {

        String sdt = this.edt_sodt_vina.getText().toString();
        ThuebaoVinaPhoneDAO thuebaoVinaPhoneDao = new ThuebaoVinaPhoneDAO();

        SessionManagement session = new SessionManagement(Balance_Tkc.this);
        username = session.getSession();

        try {
            danhsachThuebao = thuebaoVinaPhoneDao.findbysdt(sdt);
            thuebaoAdapter = new ThuebaoVinaPhoneAdapter(this, R.layout.item_tkc_balance, danhsachThuebao);
            lv_vina.setAdapter(thuebaoAdapter);
            ThueBaoVinaPhoneTask newTask = new ThueBaoVinaPhoneTask();
            newTask.execute(sdt);
            //Ghi nhật ký thao tác tìm kiếm kiếm bao gồm: user tìm kiếm, keyword tìm kiếm và menu đang sử dụng
            LogDao log = new LogDao();
            log.InsertLog(username, sdt, "Tra_cuu_so_du_tai_khoan_chinh");

        }
        catch (Exception ex) {
            Toast.makeText(this, "Error Message:" + ex.getMessage(), Toast.LENGTH_LONG);

        }
    }

    private void addControls() {
        btn_balance = findViewById(R.id.btn_balance);
        edt_sodt_vina = findViewById(R.id.edt_sodt_vina);
        lv_vina = findViewById(R.id.lv_vina);
    }


    class ThueBaoVinaPhoneTask extends AsyncTask<String, String, ArrayList<ThuebaoVinaPhone>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            thuebaoAdapter.clear();

        }

        @Override
        protected void onPostExecute(ArrayList<ThuebaoVinaPhone> thuebaoVinaPhones) {
            super.onPostExecute(thuebaoVinaPhones);
            thuebaoAdapter.clear();
            thuebaoAdapter.addAll(thuebaoVinaPhones);

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<ThuebaoVinaPhone> doInBackground(String... strings) {
            ArrayList<ThuebaoVinaPhone> result = new ArrayList<ThuebaoVinaPhone>();
            String sdt = strings[0];
            ThuebaoVinaPhoneDAO abc = new ThuebaoVinaPhoneDAO();
           try {
               result = (ArrayList)abc.findbysdt(sdt);
           } catch (Exception ex) {

           }

           return result;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_right, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_tra_cuu_balance_tkc:
                Intent intend_menu_2 = new Intent(Balance_Tkc.this, Balance_Tkc.class);
                startActivity(intend_menu_2);
                break;

            case R.id.logout:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        SessionManagement session = new SessionManagement(Balance_Tkc.this);
        session.removeSession();
        Intent intent = new Intent(Balance_Tkc.this, LoginActivity.class);
        startActivity(intent);
    }
}