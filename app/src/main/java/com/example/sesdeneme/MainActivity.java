package com.example.sesdeneme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration
    private Button a, b, c, d, e, f, random;

    private SoundPool soundPool;
    TextView currentNote;

    private int sound_a, sound_b, sound_c, sound_d, sound_e, sound_f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        a = (Button)findViewById(R.id.a);
        b = (Button)findViewById(R.id.b);
        c = (Button)findViewById(R.id.c);
        d = (Button)findViewById(R.id.d);
        e = (Button)findViewById(R.id.e);
        f = (Button)findViewById(R.id.f);
        random = (Button)findViewById(R.id.btn_random_note);
        currentNote = (TextView)findViewById(R.id.text_currentNote);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else{
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }

        sound_a = soundPool.load(this, R.raw.a3, 1);
        sound_b = soundPool.load(this, R.raw.b3, 1);
        sound_c = soundPool.load(this, R.raw.c3, 1);
        sound_d = soundPool.load(this, R.raw.d3, 1);
        sound_e = soundPool.load(this, R.raw.e3, 1);
        sound_f = soundPool.load(this, R.raw.f3, 1);


        final int[] notes = {sound_a, sound_b, sound_c, sound_d, sound_e, sound_f};

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int random_index = (int) (Math.random() * 6);
                soundPool.play(notes[random_index], 1, 1, 0, 0, 1);
                    for(int i = 0; i < 10; i++) {
                         long time = System.currentTimeMillis();
                         while (System.currentTimeMillis() != time + 1000) {
                         }
                         random_index = (int) (Math.random() * 6);
                        Toast.makeText(MainActivity.this, "kaka"+i, Toast.LENGTH_SHORT).show();
                        random.setClickable(true);


                        soundPool.play(notes[random_index], 1, 1, 0, 0, 1);
                    }
            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_a, 1, 1, 0, 0, 1);
                char ch = 'c';

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_b, 1, 1, 0, 0, 1);
                currentNote.setText("b");
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c, 1, 1, 0, 0, 1);
                                                currentNote.setText("c");


            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d, 1, 1, 0, 0, 1);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e, 1, 1, 0, 0, 1);
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f, 1, 1, 0, 0, 1);
            }
        });
    }
}
