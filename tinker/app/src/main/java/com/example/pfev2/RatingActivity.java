package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RatingActivity extends AppCompatActivity {
    Button apliqer,envoie;
    RatingBar rat ;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        rat = findViewById(R.id.ratingBar1);
        ref = FirebaseDatabase.getInstance().getReference().child("employe");
        Intent intent = getIntent();
        String data =  intent.getStringExtra("nomkey");
        Float data1 =  intent.getFloatExtra("nomkey1", 0.0f);
        Integer data2 = intent.getIntExtra("nomkey2",0);
        findViewById(R.id.sendFeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float s = (rat.getRating()+data1)/2 ;
                Integer r = (data2)+1;
                ref.child(data).child("rating").setValue(s);
                ref.child(data).child("numrate").setValue(r);
                Toast.makeText(RatingActivity.this,"Merci pour votre coopération ",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.sprti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingActivity.this, accueilClientActivity.class);
                startActivity(intent);
            }
        });
    }
}
