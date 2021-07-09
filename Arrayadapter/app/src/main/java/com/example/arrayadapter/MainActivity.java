package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hey");
        list.add("hello dear");
        list.add("bye");
        list.add("testing");
        list.add("testing2");
        list.add("hello");
        list.add("listview");
        list.add("hellooooo");
        listView = findViewById(R.id.list);
        ArrayAdapter<String>arrayAdapter= new ArrayAdapter<String>(this,R.layout.latout,R.id.textView,list);
        listView.setAdapter(arrayAdapter);

    }
}