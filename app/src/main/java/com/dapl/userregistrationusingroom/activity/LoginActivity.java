package com.dapl.userregistrationusingroom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dapl.userregistrationusingroom.AppController;
import com.dapl.userregistrationusingroom.R;
import com.dapl.userregistrationusingroom.room.entity.User;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPass;
    private Button buttonLogin, buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPass = (EditText) findViewById(R.id.et_pass);
        buttonLogin = (Button) findViewById(R.id.btn_login);
        buttonReg = (Button) findViewById(R.id.btn_reg);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = AppController.getInstance().getDb().userDao().getUserByEmail(etEmail.getText().toString().trim(), etPass.getText().toString().trim());
                if (user == null) {
                    Toast.makeText(LoginActivity.this, "You are not registered", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra(MainActivity.USER, user));
                }
            }
        });
    }
}
