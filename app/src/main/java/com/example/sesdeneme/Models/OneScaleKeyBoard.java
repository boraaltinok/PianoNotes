package com.example.sesdeneme.Models;

import android.content.Context;
import android.media.SoundPool;
import android.view.View;

import com.example.sesdeneme.R;

public class OneScaleKeyBoard {
    public static final int NOTE_A = 0;
    public static final int NOTE_A_SHARP = 1;
    public static final int NOTE_B = 2;
    public static final int NOTE_C = 3;
    public static final int NOTE_C_SHARP = 4;
    public static final int NOTE_D = 5;
    public static final int NOTE_D_SHARP = 6;
    public static final int NOTE_E = 7;
    public static final int NOTE_F = 8;
    public static final int NOTE_F_SHARP = 9;
    public static final int NOTE_G = 10;
    public static final int NOTE_G_SHARP = 11;

    private PianoTile[] keyBoard;
    private String[] letterNames;
    private String[] stringNames;
    private int[] sounds;
    private View[] allViews;

    public OneScaleKeyBoard(View[] viewsOfTiles, Context context){

        sounds = new int[12];
        letterNames = new String[12];
        stringNames = new String[12];
        keyBoard = new PianoTile[12];
        allViews = new View[12];

        initSounds();
        for(int i = 0; i < 12; i++ ){
            View view = viewsOfTiles[i];
            allViews[i] = view;
            PianoTile pianoTile = new PianoTile( sounds[i], context, i);
            keyBoard[i] = pianoTile;
        }
        initLetterNames();
        initStringNames();
    }

    public boolean isNoteSharp(View view){
        if(isNoteSharp(getIndexOf(view)))
            return true;
        else
            return false;
    }

    public boolean isNoteSharp(int noteCode){
        if(noteCode == NOTE_A_SHARP || noteCode == NOTE_C_SHARP || noteCode ==NOTE_D_SHARP
                ||noteCode== NOTE_F_SHARP || noteCode== NOTE_G_SHARP)
            return true;
        else
            return false;
    }

    public String getLetterName(int noteCode){
        return letterNames[noteCode];
    }

    public String getStringName(int noteCode){
        return stringNames[noteCode];
    }


    public void playNote(View view){
        keyBoard[getIndexOf(view)].playNoteSound();
    }
     public int getIndexOf(View view){
       for(int i = 0; i < 12; i++){
           if(allViews[i] == view)
               return i;
       }
       return -1;
    }
    private void initSounds(){
        sounds[NOTE_A] = R.raw.a3;
        sounds[NOTE_A_SHARP] = R.raw.a3;
        sounds[NOTE_B] = R.raw.b3;
        sounds[NOTE_C] = R.raw.c3;
        sounds[NOTE_C_SHARP] = R.raw.c3;
        sounds[NOTE_D] = R.raw.d3;
        sounds[NOTE_D_SHARP] = R.raw.d3;
        sounds[NOTE_E] = R.raw.e3;
        sounds[NOTE_F] = R.raw.f3;
        sounds[NOTE_F_SHARP] = R.raw.f3;
        sounds[NOTE_G] = R.raw.g3;
        sounds[NOTE_G_SHARP] = R.raw.g3;
    }

    private void initLetterNames() {
        letterNames[NOTE_A] = "A";
        letterNames[NOTE_A_SHARP] = "A#";
        letterNames[NOTE_B] = "B";
        letterNames[NOTE_C] = "C";
        letterNames[NOTE_C_SHARP] = "C#";
        letterNames[NOTE_D] = "D";
        letterNames[NOTE_D_SHARP] = "D#";
        letterNames[NOTE_E] = "E";
        letterNames[NOTE_F] = "F";
        letterNames[NOTE_F_SHARP] = "F#";
        letterNames[NOTE_G] = "G";
        letterNames[NOTE_G_SHARP] = "G#";
    };

    private void initStringNames() {
        stringNames[NOTE_A] = "La";
        stringNames[NOTE_A_SHARP] = "La diyez";
        stringNames[NOTE_B] = "Si";
        stringNames[NOTE_C] = "Do";
        stringNames[NOTE_C_SHARP] = "Do diyez";
        stringNames[NOTE_D] = "Re";
        stringNames[NOTE_D_SHARP] = "Re diyez";
        stringNames[NOTE_E] = "Mi";
        stringNames[NOTE_F] = "Fa";
        stringNames[NOTE_F_SHARP] = "Fa diyez";
        stringNames[NOTE_G] = "Sol";
        stringNames[NOTE_G_SHARP] = "Sol diyez";
    };

}
