package com.dapl.userregistrationusingroom.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dapl.userregistrationusingroom.R;
import com.dapl.userregistrationusingroom.room.entity.User;

public class MainActivity extends AppCompatActivity {

    public static final String USER = "user";
    private User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = getIntent().getExtras().getParcelable(USER);

        TextView textView = (TextView) findViewById(R.id.tv_welcome);
        textView.setText("Welcome " + user.userName);

    }
}
