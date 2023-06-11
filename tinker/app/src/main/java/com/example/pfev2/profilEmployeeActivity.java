package com.example.pfev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profilEmployeeActivity extends AppCompatActivity {
    private DatabaseReference ref;
    TextView namePofil,usernameprofil,phoneProfil,emailProfil,adresseprofil,ratin;
    RatingBar ratinbar;
    Button modf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_employee);
        String data = getIntent().getExtras().getString("name");
        ref = FirebaseDatabase.getInstance().getReference().child("employe");
        namePofil =  findViewById(R.id.namePofileempl);
        ratin = findViewById(R.id.Rating);
        ratinbar = findViewById(R.id.Ratingbar);
        usernameprofil = findViewById(R.id.usernameProfilempl);
        phoneProfil = findViewById(R.id.phoneProfilempl);
        emailProfil = findViewById(R.id.emailProfilempl);
        adresseprofil = findViewById(R.id.adresseProfilempl);
        modf = findViewById(R.id.modifempl);
        findViewById(R.id.imageBackProfilEmpl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String rate = ratin.getText().toString();
        String nom = namePofil.getText().toString();
        String prenom = usernameprofil.getText().toString();
        String num = phoneProfil.getText().toString();
        String mails = emailProfil.getText().toString();
        String adres = adresseprofil.getText().toString();
         ref.child(data).addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 employé employee = snapshot.getValue(employé.class);

                 namePofil.setText(employee.getNom() );
                 usernameprofil.setText(employee.getNom() + employee.getPrenom());
                 phoneProfil.setText(employee.getNumero());
                 emailProfil.setText(employee.getMail());
                 adresseprofil.setText(employee.getWilaya() +" / "+ employee.getService());
                 ratin.setText(Float.toString(employee.getRating()));
                 ratinbar.setRating(Float.parseFloat(Float.toString(employee.getRating())));

             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });
           modf.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(profilEmployeeActivity.this, ModifierInfoEmployeActivity.class);
                   intent.putExtra("race",data);
                   startActivity(intent);
               }
           });
        findViewById(R.id.logoutempl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profilEmployeeActivity.this,LoginEmployeeActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(profilEmployeeActivity.this,"deconecter",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.ajout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profilEmployeeActivity.this,eventeActivity.class);
                startActivity(intent);
            }
        });

    }
}
