package com.example.extendsadpater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private  List<Student> list;
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<Student>();
        list.add(new Student(R.drawable.ic_launcher_foreground,"nrayan","pokhara"));
        list.add(new Student(R.drawable.ic_launcher_foreground,"nrayan","pokhara"));
        list.add(new Student(R.drawable.ic_launcher_foreground,"nrayan","pokhara"));
        list.add(new Student(R.drawable.ic_launcher_foreground,"nrayan","pokhara"));
        list.add(new Student(R.drawable.ic_launcher_foreground,"nrayan","pokhara"));
        list.add(new Student(R.drawable.ic_launcher_foreground,"nrayan","pokhara"));

        StudentAdapter adapter = new StudentAdapter(this,R.layout.showstudent,list);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}