package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sesdeneme.Models.Melody;
import com.example.sesdeneme.Models.NoteWithBeats;

import java.io.Serializable;

public class PianoMelodyBeginnerActivity extends AppCompatActivity {

    private Button melody1, melody2, melody3, melody4, melody5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_melody_beginner);

        melody1 = (Button)findViewById(R.id.pianoBeginnerMelody1);
        melody2 = (Button)findViewById(R.id.pianoBeginnerMelody2);
        melody3 = (Button)findViewById(R.id.pianoBeginnerMelody3);
        melody4 = (Button)findViewById(R.id.pianoBeginnerMelody4);
        melody5 = (Button)findViewById(R.id.pianoBeginnerMelody5);

        final NoteWithBeats[] mlArr1 = {new NoteWithBeats( "C4", "4.OKTAV DO", "Piano", 0.5),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV FA", "Piano", 2),
                new NoteWithBeats("G4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("A4", "4.OKTAV LA", "Piano", 1),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 1)
        };

        final String mainSignature1 = "C4";

        melody1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melodyArray", (Serializable) mlArr1);
                intent.putExtra("mainSignature", mainSignature1);
                startActivity( intent);
                finish();
            }
        });

        /*PianoKey[] mlArr2 = {new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO")};

        final PianoMelody ml2 = new PianoMelody( "C4", mlArr2);
        melody2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", (Serializable) ml2);
                startActivity( intent);
                finish();
            }
        });

        PianoKey[] mlArr3 = {new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ")};

        final PianoMelody ml3 = new PianoMelody( "C4", mlArr3);
        melody3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", (Serializable) ml3);
                startActivity( intent);
                finish();
            }
        });

        PianoKey[] mlArr4 = {new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL")};

        final PianoMelody ml4 = new PianoMelody( "C4", mlArr4);
        melody4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", (Serializable) ml4);
                startActivity( intent);
                finish();
            }
        });

        PianoKey[] mlArr5 = {new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO")};

        final PianoMelody ml5 = new PianoMelody( "C4", mlArr5);
        melody5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", (Serializable) ml5);
                startActivity( intent);
                finish();
            }
        });
        */

    }
}