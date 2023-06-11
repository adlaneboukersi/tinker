package com.example.pfev2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Objects;
import java.util.UUID;

public class profilClientActivity extends AppCompatActivity {

    public Uri imageUri;
    TextView namePofileClient,phoneProfilClient,usernameProfilClient,emailProfilClient;
    ImageView img;
    Button modifierprofil,deco;

    private DatabaseReference ref;
    private FirebaseStorage storage;
    private StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_client);
        Bundle b = getIntent().getExtras();
        String data1 = b.getString("name");
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        ref = FirebaseDatabase.getInstance().getReference().child("client");
        findViewById(R.id.imageBackProfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

          img= findViewById(R.id.image);
        namePofileClient =  findViewById(R.id.namePofileClient);
        usernameProfilClient = findViewById(R.id.usernameProfilClient);
        phoneProfilClient = findViewById(R.id.phoneProfilClient);
        emailProfilClient = findViewById(R.id.emailProfilClient);

        String nom = namePofileClient.getText().toString();
        String prenom = usernameProfilClient.getText().toString();
        String num = phoneProfilClient.getText().toString();
        String mails = emailProfilClient.getText().toString();

         ref.child(data1).addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 client client = snapshot.getValue(client.class);
                 namePofileClient.setText(client.getNom());
                 usernameProfilClient.setText(client.getPrenom());
                 phoneProfilClient.setText(client.getNumero());
                 emailProfilClient.setText(client.getMail());
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });

        modifierprofil = findViewById(R.id.modifierprofil);
        modifierprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profilClientActivity.this, ModifierInfoClientActivity.class);
                intent.putExtra("date",data1);
                startActivity(intent);
            }
        });

        findViewById(R.id.logoutclient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profilClientActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(profilClientActivity.this,"deconecter",Toast.LENGTH_LONG).show();
            }
        });

      findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Chospicture();
          }
      });



    }

    private void Chospicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data.getData()!=null){

            imageUri = data.getData();
            img.setImageURI(imageUri);
            uploadimage();
        }
    }

   private void uploadimage() {
  final String randomkey = UUID.randomUUID().toString();
        StorageReference riversRef = storageReference.child("images/" + randomkey);

        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Snackbar.make(findViewById(android.R.id.content),"image uploder",Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                      Toast.makeText(profilClientActivity.this,"image non uploder",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
