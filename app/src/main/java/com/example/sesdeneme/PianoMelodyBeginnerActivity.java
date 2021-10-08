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

        final NoteWithBeats[] mlArr1 = {new NoteWithBeats( "C4", "4.OKTAV DO", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV FA", "Piano", 1),
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


        final NoteWithBeats[] mlArr2 = {new NoteWithBeats( "B4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("A4", "4.OKTAV LA", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV FA", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV DO", "Piano", 1)
        };

        final String mainSignature2 = "C4";

        melody2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melodyArray", (Serializable) mlArr2);
                intent.putExtra("mainSignature", mainSignature2);
                startActivity( intent);
                finish();
            }
        });


        final NoteWithBeats[] mlArr3 = {new NoteWithBeats( "C4", "4.OKTAV DO", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("A4", "4.OKTAV LA", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("G4", "4.OKTAV SOL", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("F4", "4.OKTAV FA", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("E4", "4.OKTAV Mİ", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("C4", "4.OKTAV DO", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5)
        };

        final String mainSignature3 = "C4";

        melody3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melodyArray", (Serializable) mlArr3);
                intent.putExtra("mainSignature", mainSignature3);
                startActivity( intent);
                finish();
            }
        });

        final NoteWithBeats[] mlArr4 = {new NoteWithBeats( "A4", "4.OKTAV DO", "Piano", 1.5),
                new NoteWithBeats("A4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("A4", "4.OKTAV LA", "Piano", 0.5),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1.5),
                new NoteWithBeats("A4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("A4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("A4", "4.OKTAV FA", "Piano", 0.5),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1.5),
                new NoteWithBeats("F4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("A4", "4.OKTAV DO", "Piano", 1.5),
                new NoteWithBeats("A4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("A4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1.5)
        };

        final String mainSignature4 = "C4";

        melody4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melodyArray", (Serializable) mlArr4);
                intent.putExtra("mainSignature", mainSignature4);
                startActivity( intent);
                finish();
            }
        });


        final NoteWithBeats[] mlArr5 = {new NoteWithBeats( "C4", "4.OKTAV DO", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV LA", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("A4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("A4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV FA", "Piano", 2),
                new NoteWithBeats("F4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV DO", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 2)
        };

        final String mainSignature5 = "C4";
        melody5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melodyArray", (Serializable) mlArr5);
                intent.putExtra("mainSignature", mainSignature5);
                startActivity( intent);
                finish();
            }
        });


    }
}