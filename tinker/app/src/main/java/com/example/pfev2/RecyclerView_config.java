package com.example.pfev2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerView_config extends AppCompatActivity {
    private static Context mConetext;

    private EmployeAdapter employeAdapter;
    public  void  setconfig(RecyclerView recyclerView, Context context , List<employé> employéList,List<String> keys, String donner,String wila)
    {
        mConetext = context ;
        employeAdapter = new EmployeAdapter(employéList,keys,donner,wila);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(employeAdapter);

    }


      public class EmployeAdapter extends  RecyclerView.Adapter<Employeitemview>{
          private  String wila;
          private List<employé> memployelist ;
        private List<String> mkeys ;
        private String donner ;


        public EmployeAdapter(List<employé> memployelist, List<String> mkeys,String donner,String wila) {
            List<employé> listemp = new ArrayList<>();
            for(employé emp : memployelist)
            {
                if(emp.getService().equals(donner))
                    if(emp.getWilaya().equals(wila)) {
                        listemp.add(emp);
                    }else if(wila.equals("Choisir votre wilaya")) {
                    listemp.add(emp);
                }


            }
            Collections.sort(listemp, new Comparator<employé>() {
                @Override
                public int compare(employé o1, employé o2) {
                    return Float.compare(o1.getRating(), o2.getRating());
                }
            });
            Collections.reverse(listemp);
            this.memployelist = listemp;
            this.mkeys = mkeys;
            this.wila = wila;
            this.donner= donner;

        }

        @NonNull
        @Override
        public Employeitemview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Employeitemview(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull Employeitemview holder, int position) {
         holder.bind(memployelist.get(position),mkeys.get(position),donner,wila);
        }

        @Override
        public int getItemCount() {
            return memployelist.size();
        }

    }
   class Employeitemview extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nom,wilaya,rating;
        private String key ;


        public  Employeitemview (ViewGroup parent)
        {
            super(LayoutInflater.from(mConetext).inflate(R.layout.activity_item_employee, parent , false));
            nom = (TextView) itemView.findViewById(R.id.nomE);
            wilaya = (TextView) itemView.findViewById(R.id.wilayaE);
            rating = (TextView) itemView.findViewById(R.id.ratingnbr);
            itemView.setOnClickListener(this);
            // parent.setOnClickListener(this);

        }


        public  void  bind (employé employe, String key, String donner,String wila)
        {

            if(employe.getService().equals(donner)) {
                nom.setText(employe.getNom() + " "+ employe.getPrenom());
                wilaya.setText(employe.getWilaya());
                rating.setText(Float.toString(employe.getRating()));
                this.key = key;
            }
        }

       @Override
       public void onClick(View v) {
         int position = getBindingAdapterPosition();
           Intent intent = new Intent(mConetext,EmployeeInformationActivity.class);
           intent.putExtra("key",employeAdapter.memployelist.get(position).getNom());
           intent.putExtra("key2",employeAdapter.memployelist.get(position).getRating());
           intent.putExtra("key3",employeAdapter.memployelist.get(position).getNumero());
           intent.putExtra("key4",employeAdapter.memployelist.get(position).getMail());
           intent.putExtra("key5",employeAdapter.memployelist.get(position).getPrenom());
           intent.putExtra("key6",employeAdapter.memployelist.get(position).getNumrate());
           mConetext.startActivity(intent);
       }
   }
}
