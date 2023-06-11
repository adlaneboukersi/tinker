package com.example.pfev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModifierInfoClientActivity extends AppCompatActivity {

    EditText nomcliente,motpasscliente,motpassnewcliente,emailcliente,prenomcliente,numcliente;
    ImageView modnom,modnewpass,modmail,modprenom,modnum,imageBack;
    Button confermodbtn,modifie;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_info_client);
        Intent intent = getIntent();
        String data =  intent.getStringExtra("date");
        nomcliente=findViewById(R.id.nomcliente);
        emailcliente=findViewById(R.id.emailcliente);
        prenomcliente=findViewById(R.id.prenomcliente);
        numcliente=findViewById(R.id.numcliente);

      //  nomcliente.setEnabled(false);
       /* motpasscliente.setEnabled(false);
        motpassnewcliente.setEnabled(false);
        emailcliente.setEnabled(false);
        prenomcliente.setEnabled(false);
        numcliente.setEnabled(false);*/
        ref = FirebaseDatabase.getInstance().getReference().child("client");







;

        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

       findViewById(R.id.confermodbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nomcliente.getText().toString().equals("")) {

                }else {
                    ref.child(data).child("nom").setValue(nomcliente.getText().toString());

                } if(prenomcliente.getText().toString().equals("")) {

                }else {
                    ref.child(data).child("prenom").setValue(prenomcliente.getText().toString());
                }
                if(emailcliente.getText().toString().equals("")) {

                }else {
                    ref.child(data).child("mail").setValue(emailcliente.getText().toString());
                }

                if(numcliente.getText().toString().equals("")) {

                }else {
                    ref.child(data).child("numero").setValue(numcliente.getText().toString());
                }


                    Intent intent = new Intent(ModifierInfoClientActivity.this, profilClientActivity.class);
                    Toast.makeText(ModifierInfoClientActivity.this,"information modifier",Toast.LENGTH_LONG).show();
                    startActivity(intent);


            }
        });


    }
}
