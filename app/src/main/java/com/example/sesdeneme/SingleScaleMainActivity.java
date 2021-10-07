package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.sesdeneme.Models.Instrument;
import com.example.sesdeneme.Models.Note;
import com.example.sesdeneme.Models.OneOctavePiano;
import com.example.sesdeneme.Models.PianoKey;

import java.util.Random;


//branch için yenilik
public class SingleScaleMainActivity extends AppCompatActivity {
    private Button randomNoteGenerator;
    private View[] noteTiles;
    private CheckBox showCurrentNote;
    private TextView currentNote, text_streak;
    int streak;
    private OneOctavePiano c4keyboard;
    Note randomNote, pressedNote;
    private PianoKey recentlyPlayedKey;

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Instrument.sp = new SoundPool.Builder().setMaxStreams(24).build();
        }
        else{
            Instrument.sp = new SoundPool(24, AudioManager.STREAM_MUSIC,0);
        }

        c4keyboard = new OneOctavePiano("C4", this, noteTiles);
        streak = 0; //current streak is 0
        text_streak.setText("STREAK: " + streak);

        final Context context = this;



        int soundID;

        randomNoteGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PianoKey randomKey;

                int rnd = new Random().nextInt(c4keyboard.getVibratorArray().length);
                randomKey = (PianoKey)c4keyboard.getVibratorArray()[rnd];

                if(recentlyPlayedKey != null){
                    c4keyboard.stopPlayingNote(recentlyPlayedKey);
                }
                c4keyboard.playNote(randomKey);
                recentlyPlayedKey = randomKey;
                
                currentNote.setText( randomKey.getCorrespondingNote().getName() + " (" + randomKey.getCorrespondingNote().getName2() + ")");

                randomNote = randomKey.getCorrespondingNote();

                for(View a: noteTiles)
                    a.setClickable(true);

            }
        });

        for(View view: noteTiles){

            /*view.setOnTouchListener(new View.OnTouchListener() {
                                        @Override

                                        public boolean onTouch(View v, MotionEvent event) {
                                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                                c4keyboard.playNote(c4keyboard.getVibratorFromView(v));
                                            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                                                c4keyboard.stopPlayingNote(c4keyboard.getVibratorFromView(v));
                                            }

                                            pressedNote = c4keyboard.getVibratorFromView(v).getCorrespondingNote();

                                            if (pressedNote.getName().equals(randomNote.getName())) {
                                                v.setBackgroundColor(getResources().getColor(R.color.day_green_primary));
                                                streak++;
                                                for (View a : noteTiles)
                                                    a.setClickable(false);

                                            } else {
                                                v.setBackgroundColor(getResources().getColor(R.color.falseNote));
                                                streak = 0;
                                            }
                                            text_streak.setText("STREAK: " + streak);
                                            waitSeconds(1, v, (PianoKey) c4keyboard.getVibratorFromView(v));

                                            return true;
                                        }
                                    });*/

            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    PianoKey playedKey = (PianoKey) c4keyboard.getVibratorFromView(v);
                    if(recentlyPlayedKey != null){
                        c4keyboard.stopPlayingNote(recentlyPlayedKey);
                    }
                    c4keyboard.playNote(playedKey);
                    recentlyPlayedKey = playedKey;
                    if(playedKey.getCorrespondingNote().getName().equals(randomNote.getName())){
                        v.setBackgroundColor(getResources().getColor(R.color.day_green_primary));
                        streak++;
                        for(View a: noteTiles)
                            a.setClickable(false);

                    }else {
                        v.setBackgroundColor(getResources().getColor(R.color.falseNote));
                        streak= 0;
                    }
                    text_streak.setText("STREAK: " + streak);
                    waitSeconds(1, v, (PianoKey) c4keyboard.getVibratorFromView(v));
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

    /*private PianoKey playRandomNote(){
        int randomIndex = (int) (Math.random()*23);
        return (PianoKey)c4keyboard.playNote(randomIndex);
    }*/

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

}
