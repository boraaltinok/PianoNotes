package com.example.sesdeneme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sesdeneme.Models.OneScaleKeyBoard;
import com.example.sesdeneme.Models.PianoTile;



//branch için yenilik
public class SingleScaleMainActivity extends AppCompatActivity {
    private Button randomNoteGenerator;
    private View[] noteTiles;
    private CheckBox showCurrentNote;
    private TextView currentNote, text_streak;
    int streak;
    int pressedNote, randomNote;
    OneScaleKeyBoard keyBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_scale_main);

        randomNoteGenerator= (Button)findViewById(R.id.btn_random_note);
        currentNote = (TextView)findViewById(R.id.text_currentNote);
        text_streak = (TextView)findViewById(R.id.text_streak);
        showCurrentNote = (CheckBox)findViewById(R.id.show_current_note);

        noteTiles = new View[12];
        noteTiles[OneScaleKeyBoard.NOTE_A] = (View)findViewById(R.id.btn_a);
        noteTiles[OneScaleKeyBoard.NOTE_A_SHARP] = (View)findViewById(R.id.btn_a_sharp);
        noteTiles[OneScaleKeyBoard.NOTE_B] = (View)findViewById(R.id.btn_b);
        noteTiles[OneScaleKeyBoard.NOTE_C] = (View)findViewById(R.id.btn_c);
        noteTiles[OneScaleKeyBoard.NOTE_C_SHARP] =  (View)findViewById(R.id.btn_c_sharp);
        noteTiles[OneScaleKeyBoard.NOTE_D] = (View)findViewById(R.id.btn_d);
        noteTiles[OneScaleKeyBoard.NOTE_D_SHARP] =(View)findViewById(R.id.btn_d_sharp);
        noteTiles[OneScaleKeyBoard.NOTE_E] = (View)findViewById(R.id.btn_e);
        noteTiles[OneScaleKeyBoard.NOTE_F] = (View)findViewById(R.id.btn_f);
        noteTiles[OneScaleKeyBoard.NOTE_F_SHARP] = (View)findViewById(R.id.btn_f_sharp);
        noteTiles[OneScaleKeyBoard.NOTE_G] = (View)findViewById(R.id.btn_g);
        noteTiles[OneScaleKeyBoard.NOTE_G_SHARP] = (View)findViewById(R.id.btn_g_sharp);

        for(View v: noteTiles)
            v.setClickable(false);

        keyBoard = new OneScaleKeyBoard(noteTiles, this);
        streak = 0; //current streak is 0
        text_streak.setText("STREAK: " + streak);

        randomNoteGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(View v: noteTiles)
                    v.setClickable(true);
                pressedNote = -1;
                randomNote = playRandomNote();
                currentNote.setText(keyBoard.getLetterName(randomNote) + " ("
                +keyBoard.getStringName(randomNote)+")");
            }
        });

        for(View view: noteTiles){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    keyBoard.playNote(view);
                    pressedNote = keyBoard.getIndexOf(view);
                    if(pressedNote == randomNote){
                        view.setBackgroundColor(getResources().getColor(R.color.day_green_primary));
                        streak++;
                        for(View v: noteTiles)
                            v.setClickable(false);

                    }else {
                        view.setBackgroundColor(getResources().getColor(R.color.falseNote));
                        streak= 0;
                    }
                    text_streak.setText("STREAK: " + streak);
                    waitSeconds(1, view);
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

    private int playRandomNote(){
        int randomIndex = (int) (Math.random()*11);
        keyBoard.playNote(noteTiles[randomIndex]);
        return randomIndex;
    }
    private void waitSeconds(int x, final View view){
        new CountDownTimer(x*1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                if(keyBoard.isNoteSharp(view))
                    view.setBackground(getResources().getDrawable(R.drawable.black_button));
                else
                    view.setBackground(getResources().getDrawable(R.drawable.white_button));
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
