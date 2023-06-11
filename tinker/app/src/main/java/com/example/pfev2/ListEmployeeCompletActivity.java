package com.example.pfev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ListEmployeeCompletActivity extends AppCompatActivity {


    private RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee_complet);
        recyclerView = (RecyclerView) findViewById(R.id.recycleviewEmploye);

        new ItemEmployeeActivity().reademploye(new ItemEmployeeActivity.Employestatus() {

            @Override
            public void employeisloaded(List<employé> employelist, List<String> keyslist, String donner, String wila) {
                new RecyclerView_config().setconfig(recyclerView,ListEmployeeCompletActivity.this,employelist,keyslist,(getIntent().getStringExtra("code")),(getIntent().getStringExtra("code1")));
            }
        });

    }
}
