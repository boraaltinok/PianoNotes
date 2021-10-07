package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class FeatureMenuActivity extends AppCompatActivity {

    private Button singleScale, btn_chordExercise, btn_melody, btn_freePiano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_menu);

        singleScale = (Button)findViewById(R.id.single_scale_btn);
        btn_chordExercise = (Button)findViewById(R.id.btn_chordExercise);
        btn_melody = (Button)findViewById(R.id.btn_melody);
        btn_freePiano = (Button)findViewById(R.id.btn_freePiano);

        singleScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SingleScaleMainActivity.class));
                finish();
            }
        });

        btn_chordExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getApplicationContext(), ChordExercise.class);
                startActivity(intent);*/
            }
        });

        btn_melody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PianoMelodyMainActivity.class));
                finish();
            }
        });

        btn_freePiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FreePianoActivity.class));
                finish();
            }
        });
    }
}