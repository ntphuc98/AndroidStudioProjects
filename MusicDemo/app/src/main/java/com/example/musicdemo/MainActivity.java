package com.example.musicdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play;
    Button stop;
    boolean isPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.startBtn);
        stop = findViewById(R.id.stopBtn);
    }

    @Override
    public void onClick(View v) {
        if (v == play && isPlay == false){
//            player = MediaPlayer.create(this , Settings.System.DEFAULT_RINGTONE_URI);
//            player = MediaPlayer.create(this, R.raw.songgio);
//            player.start();
//            player.setLooping(true);

            startService(new Intent(this, PlayerService.class));
            isPlay = true;
        }
        else  if (v == stop && isPlay == true){
            stopService(new Intent(this, PlayerService.class));
//            player.stop();
            isPlay = false;
        }
    }
}
