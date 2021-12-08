package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScoreViewModel model = new ViewModelProvider(this).get(ScoreViewModel.class);
        DisplayPOint(model);
    }

    private void DisplayPOint(ScoreViewModel model) {
        Toast.makeText(this, "this point of score a"+model.scoreA, Toast.LENGTH_SHORT).show();
    }
}