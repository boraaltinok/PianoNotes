package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sesdeneme.Models.NoteWithBeats;
import com.example.sesdeneme.Models.OneOctavePiano;
import com.example.sesdeneme.Models.PianoKey;

import java.io.Serializable;

public class PianoMelodyAdvancedActivity extends AppCompatActivity {

    private Button melody1, melody2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_melody_advanced);

        melody1 = (Button)findViewById(R.id.pianoAdvancedMelody1);
        melody2 = (Button)findViewById(R.id.pianoAdvancedMelody2);

        // eysan
        final NoteWithBeats[] mlArr1 = {new NoteWithBeats( "G4", "4.OKTAV DO", "Piano", 3),
                new NoteWithBeats("F#4", "4.OKTAV RE", "Piano", 0.25),
                new NoteWithBeats("G4", "4.OKTAV Mİ", "Piano", 0.25),
                new NoteWithBeats("A4", "4.OKTAV FA", "Piano", 0.25),
                new NoteWithBeats("F#4", "4.OKTAV SOL", "Piano", 0.25),
                new NoteWithBeats("G4", "4.OKTAV LA", "Piano", 3),
                new NoteWithBeats("F#4", "4.OKTAV Sİ", "Piano", 0.25),
                new NoteWithBeats("G4", "4.OKTAV RE", "Piano", 0.25),
                new NoteWithBeats("A4", "4.OKTAV Mİ", "Piano", 0.25),
                new NoteWithBeats("F#4", "4.OKTAV FA", "Piano", 0.25),
                new NoteWithBeats("G4", "4.OKTAV SOL", "Piano", 0.5),
                new NoteWithBeats("E4", "4.OKTAV LA", "Piano", 0.5),
                new NoteWithBeats("F#4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 0.5),
                new NoteWithBeats("E4", "4.OKTAV Mİ", "Piano", 0.5),
                new NoteWithBeats("C4", "4.OKTAV FA", "Piano", 0.5),
                new NoteWithBeats("C4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("F#4", "4.OKTAV LA", "Piano", 0.5),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 3),
                new NoteWithBeats("F#4", "4.OKTAV Mİ", "Piano", 0.5),
                new NoteWithBeats("E4", "4.OKTAV FA", "Piano", 0.5),
                new NoteWithBeats("E4", "4.OKTAV SOL", "Piano", 3),
                new NoteWithBeats("G4", "4.OKTAV LA", "Piano", 0.25),
                new NoteWithBeats("F#4", "4.OKTAV Sİ", "Piano", 0.25),
                new NoteWithBeats("G4", "4.OKTAV RE", "Piano", 0.5),
                new NoteWithBeats("G4", "4.OKTAV Mİ", "Piano", 0.25),
                new NoteWithBeats("F#4", "4.OKTAV FA", "Piano", 0.25),
                new NoteWithBeats("G4", "4.OKTAV SOL", "Piano", 0.25),
                new NoteWithBeats("A4", "4.OKTAV LA", "Piano", 0.25),
                new NoteWithBeats("D5", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("C5", "4.OKTAV RE", "Piano", 0.25),
                new NoteWithBeats("B4", "4.OKTAV Mİ", "Piano", 0.25),
                new NoteWithBeats("A4", "4.OKTAV FA", "Piano", 0.5)

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

        //diğeri
        /*PianoKey[] mlArr2 = {new PianoKey( R.raw.x5_e, OneOctavePiano.NEXT_NOTE_E, "E5", "5.OKTAV Mİ"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x5_c, OneOctavePiano.NEXT_NOTE_C, "C5", "5.OKTAV DO"),
                new PianoKey( R.raw.x5_d, OneOctavePiano.NEXT_NOTE_D, "D5", "5.OKTAV RE"),
                new PianoKey( R.raw.x5_c, OneOctavePiano.NEXT_NOTE_C, "C5", "5.OKTAV DO"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_gs, OneOctavePiano.NOTE_G_SHARP, "G4#", "4.OKTAV SOL DİYEZ"),
                new PianoKey( R.raw.x4_gs, OneOctavePiano.NOTE_G_SHARP, "G4#", "4.OKTAV SOL DİYEZ"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_gs, OneOctavePiano.NOTE_G_SHARP, "G4#", "4.OKTAV SOL DİYEZ"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ"),
                new PianoKey( R.raw.x4_gs, OneOctavePiano.NOTE_G_SHARP, "G4#", "4.OKTAV SOL DİYEZ"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_gs, OneOctavePiano.NOTE_G_SHARP, "G4#", "4.OKTAV SOL DİYEZ"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ")};

        final PianoMelody ml2 = new PianoMelody( "C4", mlArr2);
        melody2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", ml2);
                startActivity( intent);
                finish();
            }
        });*/

    }
}