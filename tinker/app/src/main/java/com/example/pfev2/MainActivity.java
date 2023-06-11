package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    CardView clientcard , employecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientcard = findViewById(R.id.clientcard);
        clientcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        employecard = findViewById(R.id.employecard);
        employecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent2 = new Intent(getApplicationContext(),LoginEmployeeActivity.class);
                startActivity(intent2);
            }
        });







    }
}
