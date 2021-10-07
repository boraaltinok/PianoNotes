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
        if( this.correspondingNote.getRank() == 1 ||
                this.correspondingNote.getRank() == 4 ||
                this.correspondingNote.getRank() == 6 ||
                this.correspondingNote.getRank() == 9 ||
                this.correspondingNote.getRank() == 11 ||
                this.correspondingNote.getRank() == 13 ||
                this.correspondingNote.getRank() == 16 ||
                this.correspondingNote.getRank() == 18 ||
                this.correspondingNote.getRank() == 21 ||
                this.correspondingNote.getRank() == 23 ||
                this.correspondingNote.getRank() == 25 ||
                this.correspondingNote.getRank() == 28 ||
                this.correspondingNote.getRank() == 30 ||
                this.correspondingNote.getRank() == 33 ||
                this.correspondingNote.getRank() == 35 ||
                this.correspondingNote.getRank() == 37 ||
                this.correspondingNote.getRank() == 40 ||
                this.correspondingNote.getRank() == 42 ||
                this.correspondingNote.getRank() == 45 ||
                this.correspondingNote.getRank() == 47 ||
                this.correspondingNote.getRank() == 49 ||
                this.correspondingNote.getRank() == 52 ||
                this.correspondingNote.getRank() == 54 ||
                this.correspondingNote.getRank() == 57 ||
                this.correspondingNote.getRank() == 59 ||
                this.correspondingNote.getRank() == 61 ||
                this.correspondingNote.getRank() == 64 ||
                this.correspondingNote.getRank() == 66 ||
                this.correspondingNote.getRank() == 69 ||
                this.correspondingNote.getRank() == 71 ||
                this.correspondingNote.getRank() == 73 ||
                this.correspondingNote.getRank() == 76 ||
                this.correspondingNote.getRank() == 78 ||
                this.correspondingNote.getRank() == 81 ||
                this.correspondingNote.getRank() == 83 ||
                this.correspondingNote.getRank() == 85
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
