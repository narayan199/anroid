package com.example.sollite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button add,view;
    EditText name,age;
    Switch s1;
    RecyclerView listView1;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add =findViewById(R.id.button2);
        view=findViewById(R.id.button);
        name=findViewById(R.id.editTextTextPersonName);
        age=findViewById(R.id.editTextTextPersonName2);
        s1=findViewById(R.id.switch1);
        listView1=findViewById(R.id.rc);
        //listiner
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    customerModel customerModel1 = new customerModel(1,name.getText().toString(),Integer.parseInt(age.getText().toString()),s1.isChecked());
                    Toast.makeText(MainActivity.this,customerModel1.toString(), Toast.LENGTH_SHORT).show();
                    DatabaseHelper databaseHelper= new DatabaseHelper(MainActivity.this);
                    databaseHelper.add(customerModel1);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
             List<customerModel> everyone=databaseHelper.getEveryone();
                ArrayAdapter arrayAdapter = new ArrayAdapter<customerModel>(MainActivity.this, android.R.layout.simple_list_item_1,everyone);
                listView1.setAdapter(arrayAdapter);
            }
        });
    }
}