package com.example.xxaemaethxx.cs354final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        Intent intent  = getIntent();
        String name = intent.getStringExtra("NAME");

        tvWelcome.setText("Hey " + name + "!, you successfully logged in!");


    }
}
