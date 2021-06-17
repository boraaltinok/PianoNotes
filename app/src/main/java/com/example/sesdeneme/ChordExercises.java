package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sesdeneme.Models.OneScaleKeyBoard;

public class ChordExercises extends AppCompatActivity {
    private Button randomChordGenerator;
    private View[] noteTiles;
    private CheckBox showCurrentNote;
    private TextView currentNote, text_streak;
    int streak;
    int pressedNote, randomNote;
    int[] currentChord;
    int[] pressedNotes;
    int pressedNotesIndex = 0;
    int wrongNotesIndex = 0;
    private View[] wrongNotes;

    OneScaleKeyBoard keyBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_exercises);

        randomChordGenerator= (Button)findViewById(R.id.btn_randomChord);
        currentNote = (TextView)findViewById(R.id.text_currentNote);
        text_streak = (TextView)findViewById(R.id.text_streak);
        showCurrentNote = (CheckBox)findViewById(R.id.show_current_note);

        wrongNotes = new View[3];
        noteTiles = new View[12];
        pressedNotes = new int[3];


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

        randomChordGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(View v: noteTiles)
                    v.setClickable(true);
                pressedNote = -1;
                int majorOrMinor = Math.random() > 0.5 ? 1: 2;
                if(majorOrMinor == 1)
                {
                    randomNote = playRandomMinorChord();


                    currentNote.setText(keyBoard.getLetterName(randomNote) + " MINOR("
                            + keyBoard.getStringName(randomNote) + " MİNÖR)");
                }
                else if(majorOrMinor == 2) {
                    randomNote = playRandomMajorChord();

                    currentNote.setText(keyBoard.getLetterName(randomNote) + " MAJÖR("
                            + keyBoard.getStringName(randomNote) + " MAJÖR)");
                }
                pressedNotesIndex = 0;
                wrongNotesIndex = 0;
            }
        });

        for(View view: noteTiles){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    keyBoard.playNote(view);
                    pressedNote = keyBoard.getIndexOf(view);
                    if(pressedNotes.length == pressedNotesIndex+1)
                    {
                        Toast.makeText(ChordExercises.this, "pressedNotes.length == pressedNotesIndex+1", Toast.LENGTH_SHORT).show();
                        pressedNotesIndex = 0;
                        boolean wrongTry = false;
                        sort(pressedNotes);
                        sort(currentChord);

                        for(int i = 0; i < currentChord.length; i++)
                        {
                            if(pressedNotes[i] != currentChord[i])
                            {
                                wrongTry = true;
                            }
                        }
                        if(wrongTry)
                        {
                            for(int i = 0; i < wrongNotes.length; i++)
                            {
                                view = wrongNotes[i];
                                //view.setBackgroundColor(getResources().getColor(R.color.falseNote));
                            }
                            wrongNotesIndex = 0;
                            pressedNotesIndex = 0;
                            Toast.makeText(ChordExercises.this, "FALSE CHORD", Toast.LENGTH_SHORT).show();
                            //waitSeconds(1, wrongNotes);
                        }
                        else{
                            Toast.makeText(ChordExercises.this, "TRUE CHORD", Toast.LENGTH_SHORT).show();
                            wrongNotesIndex = 0;
                            pressedNotesIndex = 0;
                        }
                    }
                    pressedNotes[pressedNotesIndex] = pressedNote;
                    pressedNotesIndex++;
                    //view.setBackgroundColor(getResources().getColor(R.color.unknown_chord_color));
                    wrongNotes[wrongNotesIndex] = view;
                    wrongNotesIndex++;

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
        int randomIndex = (int) (Math.random()*12);
        keyBoard.playNote(noteTiles[randomIndex]);



        return randomIndex;
    }

    private int playRandomMajorChord(){
        int randomIndex = (int) (Math.random()*12);
        keyBoard.playNote(noteTiles[randomIndex]);
        keyBoard.playNote(noteTiles[(randomIndex + 4)%12]);
        keyBoard.playNote(noteTiles[(randomIndex + 4 + 3)%12]);
        currentChord = new int[3];
        currentChord[0] = randomIndex;
        currentChord[1] = (randomIndex + 4)%12;
        currentChord[2] = (randomIndex + 4 + 3)%12;
        return randomIndex;


    }
    private int playRandomMinorChord(){
        int randomIndex = (int) (Math.random()*12);
        keyBoard.playNote(noteTiles[randomIndex]);
        keyBoard.playNote(noteTiles[(randomIndex + 3)%12]);
        keyBoard.playNote(noteTiles[(randomIndex + 3 + 4)%12]);
        currentChord = new int[3];
        currentChord[0] = randomIndex;
        currentChord[1] = (randomIndex + 3)%11;
        currentChord[2] = (randomIndex + 3 + 4)%12;
        return randomIndex;
    }
    private void waitSeconds(int x, final View[] view){
        new CountDownTimer(x*1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                for(int i = 0; i < view.length; i++) {
                    if (keyBoard.isNoteSharp(view[i]))
                        view[i].setBackground(getResources().getDrawable(R.drawable.black_button));
                    else
                        view[i].setBackground(getResources().getDrawable(R.drawable.white_button));
                }
            }

        }.start();
    }

    void sort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for(View v: noteTiles)
            v.setClickable(false);

    }
}
