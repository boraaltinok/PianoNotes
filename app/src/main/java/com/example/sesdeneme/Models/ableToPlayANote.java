package com.example.sesdeneme.Models;

public interface ableToPlayANote {
    public void vibrate();
    public void stopVibrating();
    public Note getCorrespondingNote();
    public void setSoundFile(int soundFile);
}
