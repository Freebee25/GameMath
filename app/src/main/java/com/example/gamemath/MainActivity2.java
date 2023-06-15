package com.example.gamemath;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = new MediaPlayer();

        Button playButton1 = findViewById(R.id.playButton1);
        Button playButton2 = findViewById(R.id.playButton2);
        Button playButton3 = findViewById(R.id.playButton3);
        Button playButton4 = findViewById(R.id.playButton4);
        Button playButton5 = findViewById(R.id.playButton5);
        Button playButton6 = findViewById(R.id.playButton6);
        Button playButton7 = findViewById(R.id.playButton7);
        Button playButton8 = findViewById(R.id.playButton8);
        Button playButton9 = findViewById(R.id.playButton9);
        Button playButton10 = findViewById(R.id.playButton10);
        Button playButton20 = findViewById(R.id.playButton20);
        Button playButton30 = findViewById(R.id.playButton30);
        Button playButton40 = findViewById(R.id.playButton40);
        Button playButton50 = findViewById(R.id.playButton50);
        Button playButton60 = findViewById(R.id.playButton60);
        Button playButton70 = findViewById(R.id.playButton70);
        Button playButton80 = findViewById(R.id.playButton80);
        Button playButton90 = findViewById(R.id.playButton90);
        Button playButton100 = findViewById(R.id.playButton100);

        playButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound1);
            }
        });

        playButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound2);
            }
        });

        playButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound3);
            }
        });

        playButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound4);
            }
        });

        playButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound5);
            }
        });

        playButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound6);
            }
        });

        playButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound7);
            }
        });

        playButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound8);
            }
        });

        playButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound9);
            }
        });

        playButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound10);
            }
        });

        playButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound20);
            }
        });

        playButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound30);
            }
        });

        playButton40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound40);
            }
        });

        playButton50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound50);
            }
        });

        playButton60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound60);
            }
        });

        playButton70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound70);
            }
        });

        playButton80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound80);
            }
        });

        playButton90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound90);
            }
        });

        playButton100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.sound100);
            }
        });
    }

    private void playSound(int soundId) {
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
