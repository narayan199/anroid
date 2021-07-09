package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private android.widget.Button play;
private  Button pause;
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    play = findViewById(R.id.button);
    MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.sound);
    pause= findViewById(R.id.button2);
    play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mediaPlayer.start();
        }
    });
    pause.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mediaPlayer.pause();
        }
    });
    }
}