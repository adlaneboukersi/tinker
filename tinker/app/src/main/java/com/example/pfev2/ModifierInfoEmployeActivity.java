package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ModifierInfoEmployeActivity extends AppCompatActivity {

    EditText nomemp,motpassemp,motpassnewemp,emailemp,prenomemp,numemp;
    ImageView modnom,modnewpass,modmail,modprenom,modnum,imageBack;
    Button confermodbtn;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_info_employe);
        Intent intent = getIntent();
        String data =  intent.getStringExtra("race");
        nomemp=findViewById(R.id.nomemp);
        emailemp=findViewById(R.id.emailemp);
        prenomemp=findViewById(R.id.prenomemp);
        numemp=findViewById(R.id.numemp);
         confermodbtn = findViewById(R.id.confermodbtn);
        ref = FirebaseDatabase.getInstance().getReference().child("employe");
       confermodbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(nomemp.getText().toString().equals("")) {

               }else {
                   ref.child(data).child("nom").setValue(nomemp.getText().toString());

               } if(prenomemp.getText().toString().equals("")) {

               }else {
                   ref.child(data).child("prenom").setValue(prenomemp.getText().toString());
               }
               if(emailemp.getText().toString().equals("")) {

               }else {
                   ref.child(data).child("mail").setValue(emailemp.getText().toString());
               }

               if(numemp.getText().toString().equals("")) {

               }else {
                   ref.child(data).child("numero").setValue(numemp.getText().toString());
               }


               Intent intent = new Intent(ModifierInfoEmployeActivity.this, profilEmployeeActivity.class);
               Toast.makeText(ModifierInfoEmployeActivity.this,"information modifier",Toast.LENGTH_LONG).show();
               startActivity(intent);

           }
       });



        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
