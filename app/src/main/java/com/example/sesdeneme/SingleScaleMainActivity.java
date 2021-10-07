package com.example.sesdeneme;
/*
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.sesdeneme.Models.OneOctavePiano;
import com.example.sesdeneme.Models.PianoKey;


//branch için yenilik
public class SingleScaleMainActivity extends AppCompatActivity {
    private Button randomNoteGenerator;
    private View[] noteTiles;
    private CheckBox showCurrentNote;
    private TextView currentNote, text_streak;
    int streak;
    int pressedNote, randomNote;
    private OneOctavePiano c4keyboard;

    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_scale_main);

        randomNoteGenerator= (Button)findViewById(R.id.btn_random_note);
        currentNote = (TextView)findViewById(R.id.text_currentNote);
        text_streak = (TextView)findViewById(R.id.text_streak);
        showCurrentNote = (CheckBox)findViewById(R.id.show_current_note);

        noteTiles = new View[24];

        noteTiles[OneOctavePiano.PREV_NOTE_F] = (View)findViewById(R.id.f3);
        noteTiles[OneOctavePiano.PREV_NOTE_F_SHARP] = (View)findViewById(R.id.f3s);
        noteTiles[OneOctavePiano.PREV_NOTE_G] = (View)findViewById(R.id.g3);
        noteTiles[OneOctavePiano.PREV_NOTE_G_SHARP] = (View)findViewById(R.id.g3s);
        noteTiles[OneOctavePiano.PREV_NOTE_A] =  (View)findViewById(R.id.a3);
        noteTiles[OneOctavePiano.PREV_NOTE_A_SHARP] = (View)findViewById(R.id.a3s);
        noteTiles[OneOctavePiano.PREV_NOTE_B] =(View)findViewById(R.id.b3);

        noteTiles[OneOctavePiano.NOTE_C] = (View)findViewById(R.id.c4);
        noteTiles[OneOctavePiano.NOTE_C_SHARP] =  (View)findViewById(R.id.c4s);
        noteTiles[OneOctavePiano.NOTE_D] = (View)findViewById(R.id.d4);
        noteTiles[OneOctavePiano.NOTE_D_SHARP] =(View)findViewById(R.id.d4s);
        noteTiles[OneOctavePiano.NOTE_E] = (View)findViewById(R.id.e4);
        noteTiles[OneOctavePiano.NOTE_F] = (View)findViewById(R.id.f4);
        noteTiles[OneOctavePiano.NOTE_F_SHARP] = (View)findViewById(R.id.f4s);
        noteTiles[OneOctavePiano.NOTE_G] = (View)findViewById(R.id.g4);
        noteTiles[OneOctavePiano.NOTE_G_SHARP] = (View)findViewById(R.id.g4s);
        noteTiles[OneOctavePiano.NOTE_A] = (View)findViewById(R.id.a4);
        noteTiles[OneOctavePiano.NOTE_A_SHARP] = (View)findViewById(R.id.a4s);
        noteTiles[OneOctavePiano.NOTE_B] = (View)findViewById(R.id.b4);

        noteTiles[OneOctavePiano.NEXT_NOTE_C] = (View)findViewById(R.id.c5);
        noteTiles[OneOctavePiano.NEXT_NOTE_C_SHARP] = (View)findViewById(R.id.c5s);
        noteTiles[OneOctavePiano.NEXT_NOTE_D] = (View)findViewById(R.id.d5);
        noteTiles[OneOctavePiano.NEXT_NOTE_D_SHARP] = (View)findViewById(R.id.d5s);
        noteTiles[OneOctavePiano.NEXT_NOTE_E] = (View)findViewById(R.id.e5);

        for(View v: noteTiles)
            v.setClickable(false);

        c4keyboard = new C4Keyboard(this, noteTiles);
        streak = 0; //current streak is 0
        text_streak.setText("STREAK: " + streak);

        final Context context = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            OneOctavePiano.sp = new SoundPool.Builder().setMaxStreams(24).build();
        }
        else{
            OneOctavePiano.sp = new SoundPool(24, AudioManager.STREAM_MUSIC,0);
        }

        int soundID;

        for( int i = 0; i < 24; i++){
            soundID = OneOctavePiano.sp.load( context, c4keyboard.getKeyByIndex( i).getSoundFile(), 1);
            c4keyboard.getKeyByIndex( i).setSoundID(soundID);
        }

        randomNoteGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PianoKey playedKey;
                playedKey = playRandomNote();
                currentNote.setText( playedKey.getNoteName() + " (" + playedKey.getNoteName2() + ")");

                randomNote = playedKey.getNote();

                for(View a: noteTiles)
                    a.setClickable(true);

            }
        });

        for(View view: noteTiles){

            /*view.setOnTouchListener(new View.OnTouchListener() {
                @Override

                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == android.view.MotionEvent.ACTION_DOWN ) {
                        c4keyboard.playNote( c4keyboard.getIndexOfView(v));
                    }
                    else if(event.getAction() == android.view.MotionEvent.ACTION_UP) {
                        c4keyboard.stopPlaying(c4keyboard.getIndexOfView(v));
                    }

                    pressedNote = c4keyboard.getIndexOfView(v);

                    if(pressedNote == randomNote){
                        v.setBackgroundColor(getResources().getColor(R.color.day_green_primary));
                        streak++;
                        for(View a: noteTiles)
                            a.setClickable(false);

                    }else {
                        v.setBackgroundColor(getResources().getColor(R.color.falseNote));
                        streak= 0;
                    }
                    text_streak.setText("STREAK: " + streak);
                    waitSeconds(1, v);

                    return true;
                }

            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    pressedNote = c4keyboard.getIndexOfView(v);
                    c4keyboard.playNote( pressedNote);

                    if(pressedNote == randomNote){
                        v.setBackgroundColor(getResources().getColor(R.color.day_green_primary));
                        streak++;
                        for(View a: noteTiles)
                            a.setClickable(false);

                    }else {
                        v.setBackgroundColor(getResources().getColor(R.color.falseNote));
                        streak= 0;
                    }
                    text_streak.setText("STREAK: " + streak);
                    waitSeconds(1, v, c4keyboard.getKeyByIndex(pressedNote));
                }
            });

        }

        showCurrentNote.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(showCurrentNote.isChecked())
                    currentNote.setVisibility(View.INVISIBLE);
                else
                    currentNote.setVisibility(View.VISIBLE);

            }
        });
    }

    private PianoKey playRandomNote(){
        int randomIndex = (int) (Math.random()*23);
        return (PianoKey)c4keyboard.playNote(randomIndex);
    }

    private void waitSeconds(int x, final View v, final PianoKey pk){
        new CountDownTimer(x*1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                if(pk.isSharp())
                    v.setBackground(getResources().getDrawable(R.drawable.black_button));
                else
                    v.setBackground(getResources().getDrawable(R.drawable.white_button));
            }

        }.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        for(View v: noteTiles)
            v.setClickable(false);
    }

}*/
