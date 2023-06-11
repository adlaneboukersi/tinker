package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class accueilEmployeeActivity extends AppCompatActivity {
    CardView profilcard , aviscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_employee);

        profilcard = findViewById(R.id.profilcard);
        profilcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),profilEmployeeActivity.class);
                startActivity(intent);
            }
        });


    }
}
