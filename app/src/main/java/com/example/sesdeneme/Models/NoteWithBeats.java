package com.example.sesdeneme.Models;

import android.media.SoundPool;
import android.os.Handler;

public class NoteWithBeats extends Note{

    private double beats;

    public NoteWithBeats(String name, String name2, String instrumentName, double beats) {
        super(name, name2, instrumentName);
        this.beats = beats;
    }

    public double getBeats() {
        return beats;
    }

    private int streamID;

    public void playNote(final SoundPool sp) throws InterruptedException {
        streamID = sp.play(this.getSoundFile(),1,1,1,0,1);
        Thread.sleep((long)(beats*1000));
        sp.stop(streamID);
    }
}
