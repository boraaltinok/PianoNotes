package com.example.sesdeneme.Models;

import android.content.Context;
import android.media.SoundPool;
import android.view.View;

import com.example.sesdeneme.R;

public class OneOctavePiano extends Instrument{
    private String mainSignature;
    public final static int numberOfKeys = 24;

    public static final int PREV_NOTE_F = 0;
    public static final int PREV_NOTE_F_SHARP = 1;
    public static final int PREV_NOTE_G = 2;
    public static final int PREV_NOTE_G_SHARP = 3;
    public static final int PREV_NOTE_A = 4;
    public static final int PREV_NOTE_A_SHARP = 5;
    public static final int PREV_NOTE_B = 6;

    public static final int NOTE_C = 7;                // C4
    public static final int NOTE_C_SHARP = 8;
    public static final int NOTE_D = 9;
    public static final int NOTE_D_SHARP = 10;
    public static final int NOTE_E = 11;
    public static final int NOTE_F = 12;
    public static final int NOTE_F_SHARP = 13;
    public static final int NOTE_G = 14;
    public static final int NOTE_G_SHARP = 15;
    public static final int NOTE_A = 16;
    public static final int NOTE_A_SHARP = 17;
    public static final int NOTE_B = 18;

    public static final int NEXT_NOTE_C = 19;
    public static final int NEXT_NOTE_C_SHARP = 20;
    public static final int NEXT_NOTE_D = 21;
    public static final int NEXT_NOTE_D_SHARP = 22;
    public static final int NEXT_NOTE_E = 23;

    public OneOctavePiano(String mainSignature, Context context, View[] viewArray) {
        super(context, viewArray);
        this.mainSignature = mainSignature;
        createPianoKeys();
        setSoundFilesToNotes();
    }

    public void createPianoKeys(){
        PianoKey[] arrayOfKeys = new PianoKey[24];

        if( mainSignature.equals("C3")){
            arrayOfKeys[PREV_NOTE_F] = new PianoKey( new NoteWithoutBeats("F2", "2.OKTAV FA", "Piano"), Instrument.sp, getViewArray()[0]);
            arrayOfKeys[PREV_NOTE_F_SHARP] = new PianoKey( new NoteWithoutBeats("F#2", "2.OKTAV FA DİYEZ", "Piano"), Instrument.sp, getViewArray()[1]);
            arrayOfKeys[PREV_NOTE_G] = new PianoKey( new NoteWithoutBeats("G2", "2.OKTAV SOL", "Piano"), Instrument.sp, getViewArray()[2]);
            arrayOfKeys[PREV_NOTE_G_SHARP] = new PianoKey( new NoteWithoutBeats("G#2", "2.OKTAV SOL DİYEZ", "Piano"), Instrument.sp, getViewArray()[3]);
            arrayOfKeys[PREV_NOTE_A] = new PianoKey( new NoteWithoutBeats("A2", "2.OKTAV LA", "Piano"), Instrument.sp, getViewArray()[4]);
            arrayOfKeys[PREV_NOTE_A_SHARP] = new PianoKey( new NoteWithoutBeats("A#2", "2.OKTAV LA DİYEZ", "Piano"), Instrument.sp, getViewArray()[5]);
            arrayOfKeys[PREV_NOTE_B] = new PianoKey( new NoteWithoutBeats("B2", "2.OKTAV Sİ", "Piano"), Instrument.sp, getViewArray()[6]);

            arrayOfKeys[NOTE_C] = new PianoKey( new NoteWithoutBeats("C3", "3.OKTAV DO", "Piano"), Instrument.sp, getViewArray()[7]);
            arrayOfKeys[NOTE_C_SHARP] = new PianoKey( new NoteWithoutBeats("C#3", "3.OKTAV DO DİYEZ", "Piano"), Instrument.sp, getViewArray()[8]);
            arrayOfKeys[NOTE_D] = new PianoKey( new NoteWithoutBeats("D3", "3.OKTAV RE", "Piano"), Instrument.sp, getViewArray()[9]);
            arrayOfKeys[NOTE_D_SHARP] = new PianoKey( new NoteWithoutBeats("D#3", "3.OKTAV RE DİYEZ", "Piano"), Instrument.sp, getViewArray()[10]);
            arrayOfKeys[NOTE_E] = new PianoKey( new NoteWithoutBeats("E3", "3.OKTAV Mİ", "Piano"), Instrument.sp, getViewArray()[11]);
            arrayOfKeys[NOTE_F] = new PianoKey( new NoteWithoutBeats("F3", "3.OKTAV FA", "Piano"), Instrument.sp, getViewArray()[12]);
            arrayOfKeys[NOTE_F_SHARP] = new PianoKey( new NoteWithoutBeats("F#3", "3.OKTAV FA DİYEZ", "Piano"), Instrument.sp, getViewArray()[13]);
            arrayOfKeys[NOTE_G] = new PianoKey( new NoteWithoutBeats("G3", "3.OKTAV SOL", "Piano"), Instrument.sp, getViewArray()[14]);
            arrayOfKeys[NOTE_G_SHARP] = new PianoKey( new NoteWithoutBeats("G#3", "3.OKTAV SOL DİYEZ", "Piano"), Instrument.sp, getViewArray()[15]);
            arrayOfKeys[NOTE_A] = new PianoKey( new NoteWithoutBeats("A3", "3.OKTAV LA", "Piano"), Instrument.sp, getViewArray()[16]);
            arrayOfKeys[NOTE_A_SHARP] = new PianoKey( new NoteWithoutBeats("A#3", "3.OKTAV LA DİYEZ", "Piano"), Instrument.sp, getViewArray()[17]);
            arrayOfKeys[NOTE_B] = new PianoKey( new NoteWithoutBeats("B3", "3.OKTAV Sİ", "Piano"), Instrument.sp, getViewArray()[18]);

            arrayOfKeys[NEXT_NOTE_C] = new PianoKey( new NoteWithoutBeats("C4", "4.OKTAV DO", "Piano"), Instrument.sp, getViewArray()[19]);
            arrayOfKeys[NEXT_NOTE_C_SHARP] = new PianoKey( new NoteWithoutBeats("C#4", "4.OKTAV DO DİYEZ", "Piano"), Instrument.sp, getViewArray()[20]);
            arrayOfKeys[NEXT_NOTE_D] = new PianoKey( new NoteWithoutBeats("D4", "4.OKTAV RE", "Piano"), Instrument.sp, getViewArray()[21]);
            arrayOfKeys[NEXT_NOTE_D_SHARP] = new PianoKey( new NoteWithoutBeats("D#4", "4.OKTAV RE DİYEZ", "Piano"), Instrument.sp, getViewArray()[22]);
            arrayOfKeys[NEXT_NOTE_E] = new PianoKey( new NoteWithoutBeats("E4", "4.OKTAV Mİ", "Piano"), Instrument.sp, getViewArray()[23]);

        }
        else if( mainSignature.equals("C4")){
            arrayOfKeys[PREV_NOTE_F] = new PianoKey( new NoteWithoutBeats("F3", "3.OKTAV FA", "Piano"), Instrument.sp, getViewArray()[0]);
            arrayOfKeys[PREV_NOTE_F_SHARP] = new PianoKey( new NoteWithoutBeats("F#3", "3.OKTAV FA DİYEZ", "Piano"), Instrument.sp, getViewArray()[1]);
            arrayOfKeys[PREV_NOTE_G] = new PianoKey( new NoteWithoutBeats("G3", "3.OKTAV SOL", "Piano"), Instrument.sp, getViewArray()[2]);
            arrayOfKeys[PREV_NOTE_G_SHARP] = new PianoKey( new NoteWithoutBeats("G#3", "3.OKTAV SOL DİYEZ", "Piano"), Instrument.sp, getViewArray()[3]);
            arrayOfKeys[PREV_NOTE_A] = new PianoKey( new NoteWithoutBeats("A3", "3.OKTAV LA", "Piano"), Instrument.sp, getViewArray()[4]);
            arrayOfKeys[PREV_NOTE_A_SHARP] = new PianoKey( new NoteWithoutBeats("A#3", "3.OKTAV LA DİYEZ", "Piano"), Instrument.sp, getViewArray()[5]);
            arrayOfKeys[PREV_NOTE_B] = new PianoKey( new NoteWithoutBeats("B3", "3.OKTAV Sİ", "Piano"), Instrument.sp, getViewArray()[6]);

            arrayOfKeys[NOTE_C] = new PianoKey( new NoteWithoutBeats("C4", "4.OKTAV DO", "Piano"), Instrument.sp, getViewArray()[7]);
            arrayOfKeys[NOTE_C_SHARP] = new PianoKey( new NoteWithoutBeats("C#4", "4.OKTAV DO DİYEZ", "Piano"), Instrument.sp, getViewArray()[8]);
            arrayOfKeys[NOTE_D] = new PianoKey( new NoteWithoutBeats("D4", "4.OKTAV RE", "Piano"), Instrument.sp, getViewArray()[9]);
            arrayOfKeys[NOTE_D_SHARP] = new PianoKey( new NoteWithoutBeats("D#4", "4.OKTAV RE DİYEZ", "Piano"), Instrument.sp, getViewArray()[10]);
            arrayOfKeys[NOTE_E] = new PianoKey( new NoteWithoutBeats("E4", "4.OKTAV Mİ", "Piano"), Instrument.sp, getViewArray()[11]);
            arrayOfKeys[NOTE_F] = new PianoKey( new NoteWithoutBeats("F4", "4.OKTAV FA", "Piano"), Instrument.sp, getViewArray()[12]);
            arrayOfKeys[NOTE_F_SHARP] = new PianoKey( new NoteWithoutBeats("F#4", "4.OKTAV FA DİYEZ", "Piano"), Instrument.sp, getViewArray()[13]);
            arrayOfKeys[NOTE_G] = new PianoKey( new NoteWithoutBeats("G4", "4.OKTAV SOL", "Piano"), Instrument.sp, getViewArray()[14]);
            arrayOfKeys[NOTE_G_SHARP] = new PianoKey( new NoteWithoutBeats("G#4", "4.OKTAV SOL DİYEZ", "Piano"), Instrument.sp, getViewArray()[15]);
            arrayOfKeys[NOTE_A] = new PianoKey( new NoteWithoutBeats("A4", "4.OKTAV LA", "Piano"), Instrument.sp, getViewArray()[16]);
            arrayOfKeys[NOTE_A_SHARP] = new PianoKey( new NoteWithoutBeats("A#4", "4.OKTAV LA DİYEZ", "Piano"), Instrument.sp, getViewArray()[17]);
            arrayOfKeys[NOTE_B] = new PianoKey( new NoteWithoutBeats("B4", "4.OKTAV Sİ", "Piano"), Instrument.sp, getViewArray()[18]);

            arrayOfKeys[NEXT_NOTE_C] = new PianoKey( new NoteWithoutBeats("C5", "5.OKTAV DO", "Piano"), Instrument.sp, getViewArray()[19]);
            arrayOfKeys[NEXT_NOTE_C_SHARP] = new PianoKey( new NoteWithoutBeats("C#5", "5.OKTAV DO DİYEZ", "Piano"), Instrument.sp, getViewArray()[20]);
            arrayOfKeys[NEXT_NOTE_D] = new PianoKey( new NoteWithoutBeats("D5", "5.OKTAV RE", "Piano"), Instrument.sp, getViewArray()[21]);
            arrayOfKeys[NEXT_NOTE_D_SHARP] = new PianoKey( new NoteWithoutBeats("D#5", "5.OKTAV RE DİYEZ", "Piano"), Instrument.sp, getViewArray()[22]);
            arrayOfKeys[NEXT_NOTE_E] = new PianoKey( new NoteWithoutBeats("E5", "5.OKTAV Mİ", "Piano"), Instrument.sp, getViewArray()[23]);
        }
        else if( mainSignature.equals("C5")){
            arrayOfKeys[PREV_NOTE_F] = new PianoKey( new NoteWithoutBeats("F4", "4.OKTAV FA", "Piano"), Instrument.sp, getViewArray()[0]);
            arrayOfKeys[PREV_NOTE_F_SHARP] = new PianoKey( new NoteWithoutBeats("F#4", "4.OKTAV FA DİYEZ", "Piano"), Instrument.sp, getViewArray()[1]);
            arrayOfKeys[PREV_NOTE_G] = new PianoKey( new NoteWithoutBeats("G4", "4.OKTAV SOL", "Piano"), Instrument.sp, getViewArray()[2]);
            arrayOfKeys[PREV_NOTE_G_SHARP] = new PianoKey( new NoteWithoutBeats("G#4", "4.OKTAV SOL DİYEZ", "Piano"), Instrument.sp, getViewArray()[3]);
            arrayOfKeys[PREV_NOTE_A] = new PianoKey( new NoteWithoutBeats("A4", "4.OKTAV LA", "Piano"), Instrument.sp, getViewArray()[4]);
            arrayOfKeys[PREV_NOTE_A_SHARP] = new PianoKey( new NoteWithoutBeats("A#4", "4.OKTAV LA DİYEZ", "Piano"), Instrument.sp, getViewArray()[5]);
            arrayOfKeys[PREV_NOTE_B] = new PianoKey( new NoteWithoutBeats("B4", "4.OKTAV Sİ", "Piano"), Instrument.sp, getViewArray()[6]);

            arrayOfKeys[NOTE_C] = new PianoKey( new NoteWithoutBeats("C5", "5.OKTAV DO", "Piano"), Instrument.sp, getViewArray()[7]);
            arrayOfKeys[NOTE_C_SHARP] = new PianoKey( new NoteWithoutBeats("C#5", "5.OKTAV DO DİYEZ", "Piano"), Instrument.sp, getViewArray()[8]);
            arrayOfKeys[NOTE_D] = new PianoKey( new NoteWithoutBeats("D5", "5.OKTAV RE", "Piano"), Instrument.sp, getViewArray()[9]);
            arrayOfKeys[NOTE_D_SHARP] = new PianoKey( new NoteWithoutBeats("D#5", "5.OKTAV RE DİYEZ", "Piano"), Instrument.sp, getViewArray()[10]);
            arrayOfKeys[NOTE_E] = new PianoKey( new NoteWithoutBeats("E5", "5.OKTAV Mİ", "Piano"), Instrument.sp, getViewArray()[11]);
            arrayOfKeys[NOTE_F] = new PianoKey( new NoteWithoutBeats("F5", "5.OKTAV FA", "Piano"), Instrument.sp, getViewArray()[12]);
            arrayOfKeys[NOTE_F_SHARP] = new PianoKey( new NoteWithoutBeats("F#5", "5.OKTAV FA DİYEZ", "Piano"), Instrument.sp, getViewArray()[13]);
            arrayOfKeys[NOTE_G] = new PianoKey( new NoteWithoutBeats("G5", "5.OKTAV SOL", "Piano"), Instrument.sp, getViewArray()[14]);
            arrayOfKeys[NOTE_G_SHARP] = new PianoKey( new NoteWithoutBeats("G#5", "5.OKTAV SOL DİYEZ", "Piano"), Instrument.sp, getViewArray()[15]);
            arrayOfKeys[NOTE_A] = new PianoKey( new NoteWithoutBeats("A5", "5.OKTAV LA", "Piano"), Instrument.sp, getViewArray()[16]);
            arrayOfKeys[NOTE_A_SHARP] = new PianoKey( new NoteWithoutBeats("A#5", "5.OKTAV LA DİYEZ", "Piano"), Instrument.sp, getViewArray()[17]);
            arrayOfKeys[NOTE_B] = new PianoKey( new NoteWithoutBeats("B5", "5.OKTAV Sİ", "Piano"), Instrument.sp, getViewArray()[18]);

            arrayOfKeys[NEXT_NOTE_C] = new PianoKey( new NoteWithoutBeats("C6", "6.OKTAV DO", "Piano"), Instrument.sp, getViewArray()[19]);
            arrayOfKeys[NEXT_NOTE_C_SHARP] = new PianoKey( new NoteWithoutBeats("C#6", "6.OKTAV DO DİYEZ", "Piano"), Instrument.sp, getViewArray()[20]);
            arrayOfKeys[NEXT_NOTE_D] = new PianoKey( new NoteWithoutBeats("D6", "6.OKTAV RE", "Piano"), Instrument.sp, getViewArray()[21]);
            arrayOfKeys[NEXT_NOTE_D_SHARP] = new PianoKey( new NoteWithoutBeats("D#6", "6.OKTAV RE DİYEZ", "Piano"), Instrument.sp, getViewArray()[22]);
            arrayOfKeys[NEXT_NOTE_E] = new PianoKey( new NoteWithoutBeats("E6", "6.OKTAV Mİ", "Piano"), Instrument.sp, getViewArray()[23]);

        }

        setVibratorArray( arrayOfKeys);
    }
}
