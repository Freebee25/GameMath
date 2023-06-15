package com.example.gamemath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button belajarbtn, quizbtn;
    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        belajarbtn = findViewById(R.id.belajarbtn);
        quizbtn = findViewById(R.id.quizbtn);
        audio = MediaPlayer.create(this, R.raw.sound);
        audio.setLooping(true);
        audio.setVolume(1, 1);
        audio.start();

        belajarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tunjukan aktivitas Belajar
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        quizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mulai aktivitas Quiz
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            audio.setVolume(0, 0);
        } else {
            audio.setVolume(1, 1);
        }
    }

    @Override
    public void onBackPressed() {
        audio.stop();
        MainActivity.this.finish();
    }
}
