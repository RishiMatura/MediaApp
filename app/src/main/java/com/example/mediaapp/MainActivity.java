package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button controller;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller=findViewById(R.id.controller);
        seekBar=findViewById(R.id.seekBar);
        // Media player using local source

//        mediaPlayer=MediaPlayer.create(this,R.raw.lovely);

        // Creating media player from internet source
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://paglasongs.com/files/download/id/3399");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Prepared to start", Toast.LENGTH_SHORT).show();
//                mp.start();
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                            if (fromUser){
                            mediaPlayer.seekTo(progress);
//                        }
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
            }
        });
        mediaPlayer.prepareAsync();
        controller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    controller.setText("Play");
                    mediaPlayer.pause();
                }
                else {
                    controller.setText("Pause");
                    mediaPlayer.start();
                }
            }
        });

    }
}