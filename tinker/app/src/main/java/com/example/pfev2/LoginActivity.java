package com.example.pfev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private Button singInButton;
    EditText nomclient, passwordclientlogine,emailcl;

    private DatabaseReference ref;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.textCreateAccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), SingUpActivity.class));


            }
        });
        emailcl = (EditText) findViewById(R.id.emailcliente);
        ref = FirebaseDatabase.getInstance().getReference().child("client");
        nomclient = findViewById(R.id.nomcliente);
        passwordclientlogine = findViewById(R.id.passwordcliente);
        singInButton = findViewById(R.id.singInButton);
        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nomclient.getText().toString().trim();
                String email = emailcl.getText().toString().trim();
                String passwordloginclient = passwordclientlogine.getText().toString().trim();
                ref.child(nom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        client client = snapshot.getValue(client.class);
                        if(TextUtils.isEmpty(nom)){
                            nomclient.setError("entree un nom svp");
                            return;
                        }
                        if(TextUtils.isEmpty(passwordloginclient)) {
                            passwordclientlogine.setError("entree un password svp");
                            return;
                        }
                        else if ((passwordloginclient.length()<6))
                        {
                            passwordclientlogine.setError("password court !");
                            return;
                        }
                        if(TextUtils.isEmpty(email)){
                            emailcl.setError("entree un email svp");
                            return;
                        }else if(email.equals((client.getMail()))) {
                            if (passwordloginclient.equals(client.getPassword())) {

                                Intent intent = new Intent(LoginActivity.this, accueilClientActivity.class);
                                Toast.makeText(LoginActivity.this,"bien connecter",Toast.LENGTH_LONG).show();
                                intent.putExtra("name",nom);
                                nomclient.setText("");
                                emailcl.setText("");
                                passwordclientlogine.setText("");
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "error compte n'existe pas ou mots de passe incorrect ", Toast.LENGTH_LONG).show();
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