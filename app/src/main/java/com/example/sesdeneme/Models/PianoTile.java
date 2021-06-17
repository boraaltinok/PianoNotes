package com.example.sesdeneme.Models;

import android.content.Context;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.view.View;

import com.example.sesdeneme.R;

public class PianoTile {
    private View pianoTile;
    private MediaPlayer mp;
    private int note;

    public PianoTile( ) {
    }

    public PianoTile( int soundFile, Context context, int note) {
        this.pianoTile = pianoTile;
        this.note = note;
        mp = MediaPlayer.create(context, soundFile);
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public View getPianoTile() {
        return pianoTile;
    }

    public void setPianoTile(View pianoTile) {
        this.pianoTile = pianoTile;
    }

    public void playNoteSound(){
        mp.start();
    }
}
