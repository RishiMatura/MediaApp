package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.Play);
        pause=findViewById(R.id.Pause);
        seekBar=findViewById(R.id.seekBar);
        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        mediaPlayer.start();
    }
}