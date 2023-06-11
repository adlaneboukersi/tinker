package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;
import static android.Manifest.permission.CALL_PHONE;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeInformationActivity extends AppCompatActivity {

    TextView nomempl,ratempl,numempl,emailempl,nombrerat ;
    RatingBar ratinbarempl;
    ImageView imageBackProfilEmpl,aple;
    private Button btnrating;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_information);
        Intent intent = getIntent();
        String nom =  intent.getStringExtra("key");
        Float nom1 =  intent.getFloatExtra("key2",0.0f);
        String nom2 =  intent.getStringExtra("key3");
        String nom3 =  intent.getStringExtra("key4");
        String nom4 =  intent.getStringExtra("key5");
        Integer nom5 = intent.getIntExtra("key6",0);


        nomempl  = findViewById(R.id.nomprf);
       ratinbarempl  = findViewById(R.id.ratempl);
        numempl  = findViewById(R.id.numempl);
        emailempl  = findViewById(R.id.emailempl);
        btnrating = findViewById(R.id.btnrating);
        aple = findViewById(R.id.apelle);
        nombrerat = findViewById(R.id.ratnum);
         nombrerat.setText(nom5 +" (votes)");
        nomempl.setText(nom + " "+ nom4);

        ratinbarempl.setRating(nom1);

        numempl.setText(nom2);
        emailempl.setText(nom3);

        findViewById(R.id.imageBackProfilEmpl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeInformationActivity.this, RatingActivity.class);
                intent.putExtra("nomkey",nom);
                intent.putExtra("nomkey1",nom1);
                intent.putExtra("nomkey2",nom5);
                startActivity(intent);

            }
        });

         findViewById(R.id.apelle).setOnClickListener(new View.OnClickListener() {

        @Override
            public void onClick(View v) {
                  String num = numempl.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+num));
                startActivity(intent);
             }
        });
        findViewById(R.id.emailsend).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String mail = emailempl.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(intent.EXTRA_EMAIL,mail);
                intent.putExtra(intent.EXTRA_SUBJECT,"disponibilté pour service");
              //  intent.setData(Uri.parse("tel:"+num));
                startActivity(intent.createChooser(intent,"choisisser une application"));
            }
        });





    }
}
