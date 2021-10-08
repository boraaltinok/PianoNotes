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

public class PianoMelodyIntermediateActivity extends AppCompatActivity {

    private Button melody1, melody2, melody3, melody4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_melody_intermediate);

        melody1 = (Button)findViewById(R.id.pianoIntermediateMelody1);
        melody2 = (Button)findViewById(R.id.pianoIntermediateMelody2);
        melody3 = (Button)findViewById(R.id.pianoIntermediateMelody3);
        melody4 = (Button)findViewById(R.id.pianoIntermediateMelody4);

        final NoteWithBeats[] mlArr1 = {new NoteWithBeats( "E4", "4.OKTAV DO", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV LA", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("F4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV FA", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV DO", "Piano", 2),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 1)
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


        final NoteWithBeats[] mlArr2 = {new NoteWithBeats( "C4", "4.OKTAV DO", "Piano", 1),
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

        final NoteWithBeats[] mlArr3 = {new NoteWithBeats( "E4", "4.OKTAV DO", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV LA", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV SOL", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV FA", "Piano", 2),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Mİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 2),
                new NoteWithBeats("E4", "4.OKTAV RE", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("G4", "4.OKTAV DO", "Piano", 2),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("E4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("D4", "4.OKTAV Sİ", "Piano", 1),
                new NoteWithBeats("C4", "4.OKTAV Sİ", "Piano", 4)
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

        // fur elise

        final NoteWithBeats[] mlArr4 = {new NoteWithBeats( "E5", "4.OKTAV DO", "Piano", 0.5),
                new NoteWithBeats("D#5", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("E5", "4.OKTAV LA", "Piano", 0.5),
                new NoteWithBeats("D#5", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("E5", "4.OKTAV SOL", "Piano", 0.5),
                new NoteWithBeats("B4", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("D5", "4.OKTAV FA", "Piano", 0.5),
                new NoteWithBeats("C5", "4.OKTAV Sİ", "Piano", 0.5),
                new NoteWithBeats("A4", "4.OKTAV Mİ", "Piano", 1),
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
    }
}