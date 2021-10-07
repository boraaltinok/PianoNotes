package com.example.sesdeneme.Models;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.view.View;

import java.io.Serializable;

public class PianoKey implements ableToPlayANote, Serializable {

    private Note correspondingNote;
    private SoundPool sp;
    private View v;

    public PianoKey( Note note, SoundPool sp, View v){
        correspondingNote = note;
        this.sp = sp;
        this.v = v;
    }

    public Note getCorrespondingNote() {
        return correspondingNote;
    }

    @Override
    public void setSoundFile(int soundFile) {

    }

    public View getV() {
        return v;
    }

    private int streamID;

    @Override
    public void vibrate() {
        streamID = sp.play(correspondingNote.getSoundFile(),1,1,1,0,1);
    }

    public void stopVibrating(){
        sp.stop(streamID);
    }

    public boolean isSharp() {
        if( this.correspondingNote.getRank() == 2 ||
                this.correspondingNote.getRank() == 5 ||
                this.correspondingNote.getRank() == 7 ||
                this.correspondingNote.getRank() == 10 ||
                this.correspondingNote.getRank() == 12 ||
                this.correspondingNote.getRank() == 14 ||
                this.correspondingNote.getRank() == 17 ||
                this.correspondingNote.getRank() == 19 ||
                this.correspondingNote.getRank() == 22 ||
                this.correspondingNote.getRank() == 24 ||
                this.correspondingNote.getRank() == 26 ||
                this.correspondingNote.getRank() == 29 ||
                this.correspondingNote.getRank() == 31 ||
                this.correspondingNote.getRank() == 34 ||
                this.correspondingNote.getRank() == 36 ||
                this.correspondingNote.getRank() == 38 ||
                this.correspondingNote.getRank() == 41 ||
                this.correspondingNote.getRank() == 43 ||
                this.correspondingNote.getRank() == 46 ||
                this.correspondingNote.getRank() == 48 ||
                this.correspondingNote.getRank() == 50 ||
                this.correspondingNote.getRank() == 53 ||
                this.correspondingNote.getRank() == 55 ||
                this.correspondingNote.getRank() == 58 ||
                this.correspondingNote.getRank() == 60 ||
                this.correspondingNote.getRank() == 62 ||
                this.correspondingNote.getRank() == 65 ||
                this.correspondingNote.getRank() == 67 ||
                this.correspondingNote.getRank() == 70 ||
                this.correspondingNote.getRank() == 72 ||
                this.correspondingNote.getRank() == 74 ||
                this.correspondingNote.getRank() == 77 ||
                this.correspondingNote.getRank() == 79 ||
                this.correspondingNote.getRank() == 82 ||
                this.correspondingNote.getRank() == 84 ||
                this.correspondingNote.getRank() == 86
        ){
            return true;
        }
        else{
            return false;
        }
    }

//    private MediaPlayer mp;
//    private int note;
//    private int soundFile;
//    private String noteName;
//    private String noteName2;
//    private int soundID;
//
//    public PianoKey( ) {
//    }
//
//    public PianoKey( int soundFile, int note, String noteName, String noteName2) {
//        this.soundFile = soundFile;
//        this.note = note;
//        this.noteName = noteName;
//        this.noteName2 = noteName2;
//
//    }
//
//    public int getSoundID() {
//        return soundID;
//    }
//
//    public void setSoundID(int soundID) {
//        this.soundID = soundID;
//    }
//
//    public int getNote() {
//        return note;
//    }
//
//    public void setNote(int note) {
//        this.note = note;
//    }
//
//    public int getSoundFile() {
//        return this.soundFile;
//    }
//
//    public void setSoundFile( int soundFile){
//        this.soundFile = soundFile;
//    }
//
//    public String getNoteName() {
//        return noteName;
//    }
//
//    public void setNoteName(String noteName) {
//        this.noteName = noteName;
//    }
//
//    public String getNoteName2() {
//        return noteName2;
//    }
//
//    public void setNoteName2(String noteName2) {
//        this.noteName2 = noteName2;
//    }
//
//    private int streamID;
//
//    public void playNote( SoundPool sp) {
//
//        streamID = sp.play( soundID, 1, 1, 1, 0, 1);
//
//        /*if( mp == null){
//            mp = MediaPlayer.create(context, soundFile);
//        }
//
//        mp.start();*/
//
//    }
//
//    public void stopPlayingNote( SoundPool sp) {
//
//        sp.stop( streamID);
//
//        /*mp.release();
//        mp = null;*/
//    }

    public boolean equals( PianoKey pk){
        if (this.getCorrespondingNote().getRank() == pk.getCorrespondingNote().getRank() &&
                this.getCorrespondingNote().getInstrumentName().equals(pk.getCorrespondingNote().getInstrumentName())) return true;
        else return false;
    }
}
