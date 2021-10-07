package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PianoMelodyMainActivity extends AppCompatActivity {

    private Button beginner, intermediate, advanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_melody_main);

        beginner = (Button)findViewById(R.id.beginnerMelodyPiano);
        intermediate = (Button)findViewById(R.id.intermediateMelodyPiano);
        advanced = (Button)findViewById(R.id.advancedMelodyPiano);

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PianoMelodyBeginnerActivity.class));
                finish();
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PianoMelodyIntermediateActivity.class));
                finish();
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PianoMelodyAdvancedActivity.class));
                finish();
            }
        });

    }
}