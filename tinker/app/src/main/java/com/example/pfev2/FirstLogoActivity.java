package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FirstLogoActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(FirstLogoActivity.this,MainActivity.class);
                startActivity(home);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
