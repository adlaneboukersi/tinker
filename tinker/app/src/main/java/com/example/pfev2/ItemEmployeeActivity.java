package com.example.pfev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemEmployeeActivity extends AppCompatActivity {

    private DatabaseReference ref;
    TextView nameemp, wilayaemp, ratingemp,item;
    private List<employé> employelist = new ArrayList<>();
    private String donner;
    private String wila;



    public interface Employestatus{
        void employeisloaded(List<employé> employelist,List<String> keyslist, String donner,String wila);
    }


    public  ItemEmployeeActivity () {
        ref = FirebaseDatabase.getInstance().getReference().child("employe");
    }

    public void reademploye (final Employestatus employestatus)
    {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                employelist.clear();
                List<String> keyslist = new ArrayList<>();
                for( DataSnapshot keyempl : snapshot.getChildren()){
                    keyslist.add(keyempl.getKey());
                    employé employe = keyempl.getValue(employé.class);
                        employelist.add(employe);
                }

                employestatus.employeisloaded(employelist,keyslist,donner,wila);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



}
