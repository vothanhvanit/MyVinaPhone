package com.example.myvinaphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myvinaphone.dao.UserDao;
import com.example.myvinaphone.data.model.User;
import com.example.myvinaphone.util.SessionManagement;

public class LoginActivity extends AppCompatActivity {
    public static final String  USER_NAME = "USER_NAME";
    public static final String  PASSWORD = "PASSWORD";
    public static final String  USER_BUNDLE = "USER_BUNDLE";

    Button btn_login;
    EditText txt_username;
    EditText txt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addEvents();
    }

    private void addEvents() {
        this.btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToMainActivity();
            }
        });
    }

    private void addControls() {
        txt_username = findViewById(R.id.edt_username);
        txt_password = findViewById(R.id.edt_password);
        this.btn_login = findViewById(R.id.btn_login);
    }

    ///Xử lý kết quả đăng nhập
    private void moveToMainActivity() {
        String username = txt_username.getText().toString().trim();
        String password =  txt_password.getText().toString().trim();
        UserDao userDao = new UserDao();
        boolean checkLogin = userDao.checkLogin(username, password);
        if(checkLogin) {
            User userLogin = new User(username, password);
            SessionManagement session = new SessionManagement(LoginActivity.this);
            session.saveSession(userLogin);

            Intent intent = new Intent(LoginActivity.this, Balance_Tkc.class);
            startActivity(intent);
        }
         else {
            Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show();

        }

    }
}