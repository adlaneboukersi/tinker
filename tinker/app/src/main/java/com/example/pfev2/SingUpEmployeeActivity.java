package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.example.pfev2.R.id.createmploye;
import static com.example.pfev2.R.id.servicespinner;
import static com.example.pfev2.R.id.text_input_error_icon;

public class SingUpEmployeeActivity extends AppCompatActivity {
    private Spinner servicespinner ;
    private Spinner wilayaespinner;

    EditText nom , prenom , email,confirmpassword , num , password;
    private static final Pattern PASSWORD_PATTERN;


    String MobilePattern = "(0)+(.){9}";
    static {
        PASSWORD_PATTERN = Pattern.compile("^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$");
    }

    private  employé employe ;
    FirebaseDatabase database ;
    DatabaseReference ref ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_employee);

        // pour les elements de spinner (les service)
        servicespinner = findViewById(R.id.servicespinner);

        List<String> categories = new ArrayList<>();
        categories.add(0,"Vous proposez quoi?");
        categories.add("Electricien");categories.add("Plombier");
        categories.add("Mécanicien");categories.add("Coiffeur");
        categories.add("Jardinier");categories.add("Peintre");
        categories.add("Maçon");categories.add("Menuisier");
        categories.add("Reparation Electro menagers");categories.add("ménage");
        categories.add("Déménagement");categories.add("Soudeur");
        categories.add("others");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        servicespinner.setAdapter(dataAdapter);
        servicespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Vous proposez quoi?")){
                    // faire rien
                }else{
                    //selectionner un item
                    String item = parent.getItemAtPosition(position).toString();
                    // afficher le item selectionner
                    Toast.makeText(parent.getContext(),"Selected: "+item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        wilayaespinner = findViewById(R.id.wilayaespinner);

        List<String> wilaya = new ArrayList<>();
        wilaya.add(0,"Choisir votre propre wilaya");
        wilaya.add("Adrar");wilaya.add("Chlef");wilaya.add("Laghouat");wilaya.add("Oum El Bouaghi");wilaya.add("Batna");
        wilaya.add("Béjaia");wilaya.add("Biskra");wilaya.add("Béchar");wilaya.add("Blida");wilaya.add("Bouira");
        wilaya.add("Tamanrasset");wilaya.add("Tébessa");wilaya.add("Tlemcen");wilaya.add("Tiaret");wilaya.add("Tizi Ouzou");
        wilaya.add("Alger");wilaya.add("Djelfa");wilaya.add("Jijel");wilaya.add("Sétif");wilaya.add("Saida");
        wilaya.add("Skikda");wilaya.add("Sidi Bel Abbès");wilaya.add("Annaba");wilaya.add("Guelma");wilaya.add("Constantine");
        wilaya.add("Médéa");wilaya.add("Mostaganem");wilaya.add("M'Sila");wilaya.add("Mascara");wilaya.add("Ouargla");
        wilaya.add("Oran");wilaya.add("El Bayadh");wilaya.add("Illizi");wilaya.add("Bordj Bou Arreridj");wilaya.add("Boumerdès");
        wilaya.add("El Tarf");wilaya.add("Tindouf");wilaya.add("Tissemsilt");wilaya.add("El Oued");wilaya.add("Khenchela");
        wilaya.add("Souk Ahras");wilaya.add("Tipaza");wilaya.add("Mila");wilaya.add("Aïn Defla");wilaya.add("Naâma");
        wilaya.add("Aïn Témouchent");wilaya.add("Ghardaia");wilaya.add("Relizane");


        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, wilaya);

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        wilayaespinner.setAdapter(dataAdapter2);
        wilayaespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Vous proposez quoi?")){
                    // faire rien
                }else{
                    //selectionner un item
                    String item = parent.getItemAtPosition(position).toString();
                    // afficher le item selectionner
                    Toast.makeText(parent.getContext(),"Selected: "+item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //

        findViewById(R.id.imageBackEmpl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.textSingInEmpl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        nom = (EditText) findViewById(R.id.nomemploye);
        prenom = (EditText) findViewById(R.id.prenomemploye);
        email = (EditText) findViewById(R.id.mailemploye);
        password = (EditText) findViewById(R.id.passwordemploye);
        confirmpassword = (EditText) findViewById(R.id.passwordconfirmemploye);
        num = (EditText) findViewById(R.id.numemploye);
        employe = new employé();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("employe");

        findViewById(createmploye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                String mail = email.getEditableText().toString().trim();
                String nomemploye  = nom.getText().toString().trim();
                String prenomemploye = prenom.getText().toString().trim();
                String passwordemploye = password.getText().toString().trim();
                String numemploye = num.getText().toString().trim();
                String confirmpas = confirmpassword.getText().toString().trim();
                String servic = servicespinner.getSelectedItem().toString().trim();
                String wilaya = wilayaespinner.getSelectedItem().toString().trim();

                if(TextUtils.isEmpty(prenomemploye)) {
                    prenom.setError("entree un prenom svp");
                    return;
                } else {
                    employe.setPrenom(prenom.getText().toString());
                }
                if(TextUtils.isEmpty(nomemploye)) {
                    nom.setError("entree un nom svp");
                    return;
                }else{
                     employe.setNom(nom.getText().toString());
                    }
                if((TextUtils.isEmpty(mail) || ! PASSWORD_PATTERN.matcher(mail).matches())) {
                    email.setError("entree un mails valide svp");
                    return;
                } else
                    employe.setMail(email.getText().toString());

                if(TextUtils.isEmpty(numemploye)) {
                    num.setError("entree un numero svp");
                    return;
                } else
                    employe.setNumero(num.getText().toString());

                if(servic.equals("Vous proposez quoi?")) {
                    ((TextView)servicespinner.getSelectedView()).setError("Error message");
                    return;
                } else
                employe.setService(servicespinner.getSelectedItem().toString());

                if(wilaya.equals("Choisir votre propre wilaya")) {
                    ((TextView)wilayaespinner.getSelectedView()).setError("Error message");
                    return;
                } else
                employe.setWilaya(wilayaespinner.getSelectedItem().toString());
                if(TextUtils.isEmpty(passwordemploye)) {
                    password.setError("entree un password svp");
                    return;
                }
                else if ((passwordemploye.length()<6))
                {
                    password.setError("password court !");
                    return;
                }
                else if( !passwordemploye.equals(confirmpas))
                {
                    confirmpassword.setError("erreur mot de passe incorecte");
                    return;
                }

                employe.setPassword(password.getText().toString());
                employe.getRating();
                employe.setNumrate(0);
                ref.child(employe.getNom()).setValue(employe);
                Intent intent = new Intent(SingUpEmployeeActivity.this, LoginEmployeeActivity.class);
                Toast.makeText(SingUpEmployeeActivity.this,"bien crée",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}
