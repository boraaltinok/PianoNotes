package com.example.sesdeneme.Models;

import android.content.Context;
import android.media.SoundPool;
import android.os.Parcelable;

import java.io.Serializable;

public class Melody implements Serializable {

    private String mainSignature;
    private NoteWithBeats[] melodyArray;
    private int numberOfNotes;
    public static SoundPool sp;
    private int melodyIndex;
    private Context context;
    // private Instrument instrument;


    public Melody(Context context, String mainSignature, NoteWithBeats[] melodyArray) {

        this.context = context;
        this.mainSignature = mainSignature;
        this.melodyArray = melodyArray;
        melodyIndex = 0;
        setSoundFilesToNotes();
    }

    public void setSoundFilesToNotes(){
        int soundFile;
        for( NoteWithBeats note : melodyArray){
            soundFile = sp.load( context, note.getSoundCode(), 1);
            System.out.println("BEN SOUNDFDLEIYIM XCD CzDX" + soundFile + " " + note.getName());
            note.setSoundFile(soundFile);
        }
    }

    public NoteWithBeats[] getMelodyArray() {
        return melodyArray;
    }

    public void setMelodyArray(NoteWithBeats[] melodyArray) {
        this.melodyArray = melodyArray;
    }

    public int getNumberOfNotes() {
        return numberOfNotes;
    }

    public void setNumberOfNotes(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    public String getMainSignature() {
        return mainSignature;
    }

    public void setMainSignature(String mainSignature) {
        this.mainSignature = mainSignature;
    }

    public void play() throws InterruptedException {
        for( NoteWithBeats note : melodyArray){
            System.out.print("magame");
            note.playNote(sp);
        }
    }
    public NoteWithBeats nextNote(){
        if( melodyIndex < melodyArray.length){
            NoteWithBeats note = melodyArray[melodyIndex];
            melodyIndex++;
            return note;
        }
        else{
            melodyIndex = 0;
            return null;
        }
    }

    public void refresh(){
        melodyIndex = 0;
    }

    public boolean isMelodyFinished( ){
        if( melodyIndex == melodyArray.length){
            return true;
        }
        else{
            return false;
        }
    }
}
