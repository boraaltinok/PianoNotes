package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sesdeneme.Models.OneOctavePiano;
import com.example.sesdeneme.Models.PianoKey;

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

        /*PianoKey[] mlArr1 = {new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO")};

        final PianoMelody ml1 = new PianoMelody( "C4", mlArr1);
        melody1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", ml1);
                startActivity( intent);
                finish();
            }
        });

        PianoKey[] mlArr2 = {new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
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
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),};

        final PianoMelody ml2 = new PianoMelody( "C4", mlArr2);
        melody2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", ml2);
                startActivity( intent);
                finish();
            }
        });

        PianoKey[] mlArr3 = {new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO")};

        final PianoMelody ml3 = new PianoMelody( "C4", mlArr3);
        melody3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", ml3);
                startActivity( intent);
                finish();
            }
        });

        // fur elise
        PianoKey[] mlArr4 = {new PianoKey( R.raw.x4_c, OneOctavePiano.NOTE_C, "C4", "4.OKTAV DO"),
                new PianoKey( R.raw.x4_d, OneOctavePiano.NOTE_D, "D4", "4.OKTAV RE"),
                new PianoKey( R.raw.x4_e, OneOctavePiano.NOTE_E, "E4", "4.OKTAV Mİ"),
                new PianoKey( R.raw.x4_f, OneOctavePiano.NOTE_F, "F4", "4.OKTAV FA"),
                new PianoKey( R.raw.x4_g, OneOctavePiano.NOTE_G, "G4", "4.OKTAV SOL"),
                new PianoKey( R.raw.x4_a, OneOctavePiano.NOTE_A, "A4", "4.OKTAV LA"),
                new PianoKey( R.raw.x4_b, OneOctavePiano.NOTE_B, "B4", "4.OKTAV Sİ")};

        final PianoMelody ml4 = new PianoMelody( "C4", mlArr4);
        melody4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PianoPlayMelodyActivity.class);
                intent.putExtra("melody", ml4);
                startActivity( intent);
                finish();
            }
        });*/
    }
}