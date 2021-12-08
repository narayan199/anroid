package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        //Making refrence
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dref= database.getReference("message");
        //writeing to database
        dref.setValue("welcome to andorid world");
        //reading from database
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //here we want to execute when reciving data
                String s = (String) snapshot.getValue();
              textView.setText(""+s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            //for eroor occcur during reteriving
            }
        });
    }
}