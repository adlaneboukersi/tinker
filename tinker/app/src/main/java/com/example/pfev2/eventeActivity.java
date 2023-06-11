package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class eventeActivity extends AppCompatActivity {
    EditText titre,localitaion,details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evente);
        titre = findViewById(R.id.nom);
        localitaion = findViewById(R.id.Local);
        details = findViewById(R.id.desc);
        findViewById(R.id.addevnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!titre.getText().toString().isEmpty() && !localitaion.getText().toString().isEmpty() && !details
                        .getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, titre.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, localitaion.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, details.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, "true");
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else{
                        Toast.makeText(eventeActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(eventeActivity.this, "svp remplisez tout les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
