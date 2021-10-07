package com.example.sesdeneme.Models;

import android.media.SoundPool;

import com.example.sesdeneme.R;

import java.io.Serializable;

public abstract class Note implements Serializable {

    private String name;
    private String name2;
    private String instrumentName;
    private int rank;               // out of 88
    private int soundCode;
    private int soundFile;

    public Note(String name, String name2, String instrumentName) {
        this.name = name;
        this.name2 = name2;
        this.instrumentName = instrumentName;

        if( instrumentName.equals("Piano")){
            switch(name) {
                case "A0":
                    rank = 1;
                    //soundCode = R.raw.x0_a;
                    break;
                case "A#0":
                    rank = 2;
                    //soundCode = R.raw.x0_as;
                    break;
                case "B0":
                    rank = 3;
                    soundCode = R.raw.x0_b;
                    break;
                case "C1":
                    rank = 4;
                    soundCode = R.raw.x1_c;
                    break;
                case "C#1":
                    rank = 5;
                    soundCode = R.raw.x1_cs;
                    break;
                case "D1":
                    rank = 6;
                    soundCode = R.raw.x1_d;
                    break;
                case "D#1":
                    rank = 7;
                    soundCode = R.raw.x1_ds;
                    break;
                case "E1":
                    rank = 8;
                    soundCode = R.raw.x1_e;
                    break;
                case "F1":
                    rank = 9;
                    soundCode = R.raw.x1_f;
                    break;
                case "F#1":
                    rank = 10;
                    soundCode = R.raw.x1_fs;
                    break;
                case "G1":
                    rank = 11;
                    soundCode = R.raw.x1_g;
                    break;
                case "G#1":
                    rank = 12;
                    soundCode = R.raw.x1_gs;
                    break;
                case "A1":
                    rank = 13;
                    soundCode = R.raw.x1_a;
                    break;
                case "A#1":
                    rank = 14;
                    soundCode = R.raw.x1_as;
                    break;
                case "B1":
                    rank = 15;
                    soundCode = R.raw.x1_b;
                    break;
                case "C2":
                    rank = 16;
                    soundCode = R.raw.x2_c;
                    break;
                case "C#2":
                    rank = 17;
                    soundCode = R.raw.x2_cs;
                    break;
                case "D2":
                    rank = 18;
                    soundCode = R.raw.x2_d;
                    break;
                case "D#2":
                    rank = 19;
                    soundCode = R.raw.x2_ds;
                    break;
                case "E2":
                    rank = 20;
                    soundCode = R.raw.x2_e;
                    break;
                case "F2":
                    rank = 21;
                    soundCode = R.raw.x2_f;
                    break;
                case "F#2":
                    rank = 22;
                    soundCode = R.raw.x2_fs;
                    break;
                case "G2":
                    rank = 23;
                    soundCode = R.raw.x2_g;
                    break;
                case "G#2":
                    rank = 24;
                    soundCode = R.raw.x2_gs;
                    break;
                case "A2":
                    rank = 25;
                    soundCode = R.raw.x2_a;
                    break;
                case "A#2":
                    rank = 26;
                    soundCode = R.raw.x2_as;
                    break;
                case "B2":
                    rank = 27;
                    soundCode = R.raw.x2_b;
                    break;
                case "C3":
                    rank = 28;
                    soundCode = R.raw.x3_c;
                    break;
                case "C#3":
                    rank = 29;
                    soundCode = R.raw.x3_cs;
                    break;
                case "D3":
                    rank = 30;
                    soundCode = R.raw.x3_d;
                    break;
                case "D#3":
                    rank = 31;
                    soundCode = R.raw.x3_ds;
                    break;
                case "E3":
                    rank = 32;
                    soundCode = R.raw.x3_e;
                    break;
                case "F3":
                    rank = 33;
                    soundCode = R.raw.x3_f;
                    break;
                case "F#3":
                    rank = 34;
                    soundCode = R.raw.x3_fs;
                    break;
                case "G3":
                    rank = 35;
                    soundCode = R.raw.x3_g;
                    break;
                case "G#3":
                    rank = 36;
                    soundCode = R.raw.x3_gs;
                    break;
                case "A3":
                    rank = 37;
                    soundCode = R.raw.x3_a;
                    break;
                case "A#3":
                    rank = 38;
                    soundCode = R.raw.x3_as;
                    break;
                case "B3":
                    rank = 39;
                    soundCode = R.raw.x3_b;
                    break;
                case "C4":
                    rank = 40;
                    soundCode = R.raw.x4_c;
                    break;
                case "C#4":
                    rank = 41;
                    soundCode = R.raw.x4_cs;
                    break;
                case "D4":
                    rank = 42;
                    soundCode = R.raw.x4_d;
                    break;
                case "D#4":
                    rank = 43;
                    soundCode = R.raw.x4_ds;
                    break;
                case "E4":
                    rank = 44;
                    soundCode = R.raw.x4_e;
                    break;
                case "F4":
                    rank = 45;
                    soundCode = R.raw.x4_f;
                    break;
                case "F#4":
                    rank = 46;
                    soundCode = R.raw.x4_fs;
                    break;
                case "G4":
                    rank = 47;
                    soundCode = R.raw.x4_g;
                    break;
                case "G#4":
                    rank = 48;
                    soundCode = R.raw.x4_gs;
                    break;
                case "A4":
                    rank = 49;
                    soundCode = R.raw.x4_a;
                    break;
                case "A#4":
                    rank = 50;
                    soundCode = R.raw.x4_as;
                    break;
                case "B4":
                    rank = 51;
                    soundCode = R.raw.x4_b;
                    break;
                case "C5":
                    rank = 52;
                    soundCode = R.raw.x5_c;
                    break;
                case "C#5":
                    rank = 53;
                    soundCode = R.raw.x5_cs;
                    break;
                case "D5":
                    rank = 54;
                    soundCode = R.raw.x5_d;
                    break;
                case "D#5":
                    rank = 55;
                    soundCode = R.raw.x5_ds;
                    break;
                case "E5":
                    rank = 56;
                    soundCode = R.raw.x5_e;
                    break;
                case "F5":
                    rank = 57;
                    soundCode = R.raw.x5_f;
                    break;
                case "F#5":
                    rank = 58;
                    soundCode = R.raw.x5_fs;
                    break;
                case "G5":
                    rank = 59;
                    soundCode = R.raw.x5_g;
                    break;
                case "G#5":
                    rank = 60;
                    soundCode = R.raw.x5_gs;
                    break;
                case "A5":
                    rank = 61;
                    soundCode = R.raw.x5_a;
                    break;
                case "A#5":
                    rank = 62;
                    soundCode = R.raw.x5_as;
                    break;
                case "B5":
                    rank = 63;
                    soundCode = R.raw.x5_b;
                    break;
                case "C6":
                    rank = 64;
                    soundCode = R.raw.x6_c;
                    break;
                case "C#6":
                    rank = 65;
                    soundCode = R.raw.x6_cs;
                    break;
                case "D6":
                    rank = 66;
                    soundCode = R.raw.x6_d;
                    break;
                case "D#6":
                    rank = 67;
                    soundCode = R.raw.x6_ds;
                    break;
                case "E6":
                    rank = 68;
                    soundCode = R.raw.x6_e;
                    break;
                case "F6":
                    rank = 69;
                    soundCode = R.raw.x6_f;
                    break;
                case "F#6":
                    rank = 70;
                    soundCode = R.raw.x6_fs;
                    break;
                case "G6":
                    rank = 71;
                    soundCode = R.raw.x6_g;
                    break;
                case "G#6":
                    rank = 72;
                    soundCode = R.raw.x6_gs;
                    break;
                case "A6":
                    rank = 73;
                    soundCode = R.raw.x6_a;
                    break;
                case "A#6":
                    rank = 74;
                    soundCode = R.raw.x6_as;
                    break;
                case "B6":
                    rank = 75;
                    soundCode = R.raw.x6_b;
                    break;
                case "C7":
                    rank = 76;
                    soundCode = R.raw.x7_c;
                    break;
                case "C#7":
                    rank = 77;
                    soundCode = R.raw.x7_cs;
                    break;
                case "D7":
                    rank = 78;
                    soundCode = R.raw.x7_d;
                    break;
                case "D#7":
                    rank = 79;
                    soundCode = R.raw.x7_ds;
                    break;
                case "E7":
                    rank = 80;
                    soundCode = R.raw.x7_e;
                    break;
                case "F7":
                    rank = 81;
                    soundCode = R.raw.x7_f;
                    break;
                case "F#7":
                    rank = 82;
                    soundCode = R.raw.x7_fs;
                    break;
                case "G7":
                    rank = 83;
                    soundCode = R.raw.x7_g;
                    break;
                case "G#7":
                    rank = 84;
                    soundCode = R.raw.x7_gs;
                    break;
                case "A7":
                    rank = 85;
                    soundCode = R.raw.x7_a;
                    break;
                case "A#7":
                    rank = 86;
                    soundCode = R.raw.x7_as;
                    break;
                case "B7":
                    rank = 87;
                    soundCode = R.raw.x7_b;
                    break;
                case "C8":
                    rank = 88;
                    soundCode = R.raw.x8_c;
                    break;
            }
        }
        else if( instrumentName.equals("Guitar")){

        }
        else if( instrumentName.equals("Violin")){

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSoundCode() {
        return soundCode;
    }

    public void setSoundCode(int soundCode) {
        this.soundCode = soundCode;
    }

    public int getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(int soundFile) {
        this.soundFile = soundFile;
    }

}

