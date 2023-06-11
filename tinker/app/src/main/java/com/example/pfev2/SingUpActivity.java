package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

import static com.example.pfev2.R.id.createcompte;

public  class SingUpActivity extends AppCompatActivity {

    EditText nom , prenom , email , num , password, confirmpassword;
     private  client client ;

    private static final Pattern PASSWORD_PATTERN;

    static {
        PASSWORD_PATTERN = Pattern.compile("^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$");
    }


    FirebaseDatabase database ;
    DatabaseReference ref ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.textSingIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        nom = (EditText) findViewById(R.id.firstname);
        prenom = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.site);
        password = (EditText) findViewById(R.id.pass);
        confirmpassword = (EditText) findViewById(R.id.confirmpass);
        num = (EditText) findViewById(R.id.number);
        client = new client();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("client");

        findViewById(createcompte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                String mail = email.getEditableText().toString().trim();
                String nomclient  = nom.getText().toString().trim();
               String prenomclient = prenom.getText().toString().trim();
                String passwordclient = password.getText().toString().trim();
                String numeroclient = num.getText().toString().trim();
                String confirmpas = confirmpassword.getText().toString().trim();

                if(TextUtils.isEmpty(nomclient)) {
                    nom.setError("entree un nom svp");
                    return;
                } else
                    client.setNom(nom.getText().toString());
                if((TextUtils.isEmpty(mail) || ! PASSWORD_PATTERN.matcher(mail).matches())) {
                    email.setError("entree un mails valide svp");
                    return;
                } else
                client.setMail(email.getText().toString());
                if(TextUtils.isEmpty(numeroclient)) {
                    num.setError("entree un numero svp");
                    return;
                } else
                    client.setNumero(num.getText().toString());
                if(TextUtils.isEmpty(passwordclient)) {
                    password.setError("entree un password svp");
                    return;
                }
                else if ((passwordclient.length()<6))
                {
                    password.setError("password court !");
                    return;
                }
                 else if( !passwordclient.equals(confirmpas))
                {
                    confirmpassword.setError("erreur mot de passe incorecte");
                    return;
                }


                 client.setPassword(password.getText().toString());

                 client.setPrenom(prenom.getText().toString());

                ref.child(client.getNom()).setValue(client);
                Intent intent = new Intent(SingUpActivity.this, LoginActivity.class);
                Toast.makeText(SingUpActivity.this,"bien crée",Toast.LENGTH_LONG).show();
                startActivity(intent);



            }
        });
    }


}


