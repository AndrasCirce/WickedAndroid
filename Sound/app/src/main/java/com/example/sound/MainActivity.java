package com.example.sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mp, mp2;
    Button sonido1, sonido2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonido1 = (Button)findViewById(R.id.btn_sonido1);
        sonido2 = (Button)findViewById(R.id.btn_sonido2);
        mp = MediaPlayer.create(this, R.raw.sound_short);
        mp2 = MediaPlayer.create(this, R.raw.sound_long);
        sonido1.setOnClickListener(this);
        sonido2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sonido1:
                mp.start();
                break;

            case R.id.btn_sonido2:
                mp2.start();
                break;
        }
    }
}