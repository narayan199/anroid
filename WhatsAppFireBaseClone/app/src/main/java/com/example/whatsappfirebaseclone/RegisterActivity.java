package com.example.whatsappfirebaseclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    public EditText userET,passwordET,emailET;
    public Button register;
    //fireBase object
   FirebaseAuth auth;
   DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userET=findViewById(R.id.username);
        passwordET=findViewById(R.id.password);
        emailET=findViewById(R.id.email);
        register= findViewById(R.id.register);
        //instinciate fire base
        auth = FirebaseAuth.getInstance();
        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userET.getText().toString();
                String password = passwordET.getText().toString();
                String email = emailET.getText().toString();
                if (TextUtils.isEmpty(username)|TextUtils.isEmpty(password)|TextUtils.isEmpty(email))
                {
                    Toast.makeText(RegisterActivity.this, "sab vor ", Toast.LENGTH_SHORT).show();
                }
                RegisterNow(username,password,email);
            }
        });
    }
    private void RegisterNow(final String username,final String password,final String email)
    {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()){
                         FirebaseUser user = auth.getCurrentUser();
                         assert user != null;
                         String userId= user.getUid();
                         dref = FirebaseDatabase.getInstance().getReference("My users")
                         .child(userId);
                         //HashMap
                         HashMap<String,String> hashMap = new HashMap<>();
                         hashMap.put("Id",userId);
                         hashMap.put("name",username);
                         hashMap.put("Image","default");
                         //register a user and return to login
                         dref.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                             @Override
                             public void onComplete(@NonNull Task<Void> task) {
                                 if (task.isSuccessful())
                                 {
                                     //intent to go to login after complete registertation
                                     Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                                     i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                     startActivity(i);
                                     finish();
                                 }
                             }
                         });

                     }
                     else
                     {
                         Toast.makeText(RegisterActivity.this, "Inavalid Email or password", Toast.LENGTH_SHORT).show();
                     }
                    }
                });
    }
}