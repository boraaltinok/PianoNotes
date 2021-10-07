package com.example.sesdeneme.Models;

import android.content.Context;
import android.media.SoundPool;
import android.view.View;

public abstract class Instrument implements playable{
    private String name;
    public static SoundPool sp;
    private ableToPlayANote[] vibratorArray;
    private View[] viewArray;
    private Context context;

    public Instrument(Context context, View[] viewArray){
        this.context = context;
        this.viewArray = viewArray;
    }

    public void setSoundFilesToNotes(){
        for( ableToPlayANote vibrator : vibratorArray){
            System.out.println("^#######################################################" + vibrator.getCorrespondingNote().getName() + " " + vibrator.getCorrespondingNote().getSoundCode());
            int soundFile = sp.load(context, vibrator.getCorrespondingNote().getSoundCode(), 1);
            System.out.println("^#######################################################" + soundFile);
            vibrator.getCorrespondingNote().setSoundFile(soundFile);
        }
    }

    public ableToPlayANote[] getVibratorArray() {
        return vibratorArray;
    }

    public void setVibratorArray(ableToPlayANote[] vibratorArray) {
        this.vibratorArray = vibratorArray;
    }

    public View[] getViewArray() {
        return viewArray;
    }

    public boolean equals(Instrument instrument){
        if( this.name.equals(instrument.name)) return true;
        else return false;
    }

    public String getName() {
        return name;
    }

    public void playNote(ableToPlayANote vibrator){
        vibrator.vibrate();
    };

    public void stopPlayingNote( ableToPlayANote vibrator){
        vibrator.stopVibrating();
    }

    public ableToPlayANote getVibratorFromView(View v){
        int i = 0;
        while( !viewArray[i].equals(v)){
            i++;
        }
        return vibratorArray[i];
    }
    ;

    // void playChord();
    // void playMelody( Melody melody);
}
