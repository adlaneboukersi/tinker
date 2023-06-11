package com.example.pfev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginEmployeeActivity extends AppCompatActivity {
    private Button singInButtonEmpl;
    EditText nomemploye,passwordemployelogine,emailempl;

    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);
        findViewById(R.id.textCreateAccountEmpl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), SingUpEmployeeActivity.class));


            }
        });
        ref = FirebaseDatabase.getInstance().getReference().child("employe");
       emailempl  = (EditText) findViewById(R.id.emailempoye);
        nomemploye = findViewById(R.id.nomEmploye);
        passwordemployelogine  = findViewById(R.id.passwordemployer);
        findViewById(R.id.singInButtonEmpl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nomemploye.getText().toString().trim();
                String passwordloginempl = passwordemployelogine.getText().toString().trim();
                String email =  emailempl.getText().toString().trim();
                ref.child(nom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        employé employee = snapshot.getValue(employé.class);

                        if(TextUtils.isEmpty(nom)){
                           nomemploye.setError("entree un nom svp");
                            return;
                        }
                        if(TextUtils.isEmpty(passwordloginempl)) {
                            passwordemployelogine.setError("entree un password svp");
                            return;
                        }
                        else if ((passwordloginempl.length()<6))
                        {
                            passwordemployelogine.setError("password court !");
                            return;
                        }
                        if(TextUtils.isEmpty(email)){
                            emailempl.setError("entree un mail svp");
                            return;
                        }else if(email.equals(employee.getMail())) {
                            if (passwordloginempl.equals(employee.getPassword())) {
                                Intent intent = new Intent(LoginEmployeeActivity.this, profilEmployeeActivity.class);
                                Toast.makeText(LoginEmployeeActivity.this,"bien connecter",Toast.LENGTH_LONG).show();
                                intent.putExtra("name",nom);
                                nomemploye.setText("");
                                emailempl.setText("");
                                passwordemployelogine.setText("");
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginEmployeeActivity.this, "error compte n'existe pas ou mots de passe incorrect ", Toast.LENGTH_LONG).show();
                            }
                        }




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
    }
}