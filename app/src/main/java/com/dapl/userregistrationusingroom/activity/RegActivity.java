package com.dapl.userregistrationusingroom.activity;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dapl.userregistrationusingroom.AppController;
import com.dapl.userregistrationusingroom.R;
import com.dapl.userregistrationusingroom.room.entity.User;

public class RegActivity extends AppCompatActivity {

    EditText etName, etEmail, etPass;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPass = (EditText) findViewById(R.id.et_pass);
        btnReg = (Button) findViewById(R.id.btn_reg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = AppController.getInstance().getDb().userDao().isEmailAvailable(etEmail.getText().toString().trim());
                if (u != null) {
                    Toast.makeText(RegActivity.this, "Email address is already used", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(Parcel.obtain());
                user.userEmail = etEmail.getText().toString().trim();
                user.userName = etName.getText().toString().trim();
                user.userPass = etPass.getText().toString().trim();

                AppController.getInstance().getDb().userDao().insertAll(user);
            }
        });


    }
}
