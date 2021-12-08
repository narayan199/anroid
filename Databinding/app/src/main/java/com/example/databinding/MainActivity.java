package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainActivityContracter.view {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityPresenter presenter = new MainActivityPresenter(this,getApplicationContext());
        StudentData studentData = new StudentData("student grade ","10");
        binding.setGrader(studentData);
        binding.setPresneter(presenter);

    }

    @Override
    public void ShowData(StudentData studentData) {
        String grade = studentData.getGrade();
        Toast.makeText(MainActivity.this, grade, Toast.LENGTH_SHORT).show();
    }
}