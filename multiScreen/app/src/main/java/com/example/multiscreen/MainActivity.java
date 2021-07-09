 package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
     public static final String EXTRA_NAME = "com.example.multiscreen.extra.NAME";
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
        public void openActivity (View v )
    {
            Toast.makeText(this, "Opening Second Activity", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity2.class);
        textView = findViewById(R.id.text);
        String name = textView.getText().toString();
            intent.putExtra(EXTRA_NAME,name);
            startActivity(intent);
        }
}