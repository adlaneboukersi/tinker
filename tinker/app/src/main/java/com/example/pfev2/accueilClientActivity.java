package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class accueilClientActivity extends AppCompatActivity {
    ImageView ProfilClient , elec,plomb,mecani,coiffeur,jardinier,peintre,macon,miniuisier,elctro,menage,demaneg,soudeur,other;
    TextView servi;
    private Spinner wilayaespinner ;

    static accueilClientActivity INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        INSTANCE=this;
        setContentView(R.layout.activity_accueil_client);
        wilayaespinner = findViewById(R.id.wilayaespinner);

        List<String> wilaya = new ArrayList<>();
        wilaya.add(0,"Choisir votre wilaya");
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


        ProfilClient = findViewById(R.id.ProfilClient);
        ProfilClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this,profilClientActivity.class);
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                startActivity(intent);
            }
        });

        elec = findViewById(R.id.electid);
      elec.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
                  Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                  intent.putExtra("code","Electricien");
              String wil = wilayaespinner.getSelectedItem().toString();
                  intent.putExtra("code1",wil);
                  startActivity(intent);
              }
      });
        plomb = findViewById(R.id.idplombier);
        plomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Plombier");
               // intent.putExtra("code1",wil);
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        mecani = findViewById(R.id.mecaid);
        mecani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Mécanicien");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        coiffeur = findViewById(R.id.idcoifeur);
        coiffeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Coiffeur");
                String wil = wilayaespinner.getSelectedItem().toString();
                if (wil.equals(""))
                {

                }else {
                    intent.putExtra("code1", wil);
                }
                startActivity(intent);
            }
        });
        jardinier = findViewById(R.id.idjardinier);
        jardinier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Jardinier");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        peintre = findViewById(R.id.idpeintre);
        peintre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Peintre");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        macon = findViewById(R.id.idmacon);
        macon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Maçon");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        miniuisier = findViewById(R.id.idminiuisier);
        miniuisier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Menuisier");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        macon = findViewById(R.id.idmacon);
        macon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Maçon");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        elctro = findViewById(R.id.idelectro);
        elctro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Reparation Electro menagers");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        menage = findViewById(R.id.iddemenag);
        menage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","ménage");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        demaneg = findViewById(R.id.iddemenagement);
        demaneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Déménagement");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });
        soudeur = findViewById(R.id.soudeur);
        soudeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","Soudeur");
                String wil = wilayaespinner.getSelectedItem().toString();
                intent.putExtra("code1",wil);
                startActivity(intent);
            }
        });

        other = findViewById(R.id.idother);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(accueilClientActivity.this, ListEmployeeCompletActivity.class);
                intent.putExtra("code","others");
                String wil = wilayaespinner.getSelectedItem().toString();
                if (wil.equals("Choisir votre wilaya"))
                {

                }else {
                    intent.putExtra("code1", wil);
                }
                startActivity(intent);
            }
        });
    }


}

