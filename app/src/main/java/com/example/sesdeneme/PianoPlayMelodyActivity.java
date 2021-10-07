package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sesdeneme.Models.Instrument;
import com.example.sesdeneme.Models.Melody;
import com.example.sesdeneme.Models.Note;
import com.example.sesdeneme.Models.NoteWithBeats;
import com.example.sesdeneme.Models.OneOctavePiano;
import com.example.sesdeneme.Models.PianoKey;

public class PianoPlayMelodyActivity extends AppCompatActivity {

    private String mainSignature;
    private Melody melody;
    private NoteWithBeats[] melodyArray;
    private Button start;
    private TextView textViewSignature, textViewGZ;
    private View[] pianoKeyViews;
    private GestureDetectorCompat mDetector;
    private NoteWithBeats nextNoteInTheMelody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_play_melody);

        start = (Button)findViewById(R.id.btn_play_melody);
        textViewSignature = (TextView)findViewById(R.id.mainSignature);
        textViewGZ = (TextView)findViewById(R.id.text_pianoMelodyGZ);

        Bundle extras = getIntent().getExtras();

        if( extras != null){
            melodyArray = (NoteWithBeats[]) extras.get("melodyArray");
            mainSignature = (String) extras.get("mainSignature");
        }

        pianoKeyViews = new View[24];

        pianoKeyViews[OneOctavePiano.PREV_NOTE_F] = (View)findViewById(R.id.prev_f);
        pianoKeyViews[OneOctavePiano.PREV_NOTE_F_SHARP] = (View)findViewById(R.id.prev_fs);
        pianoKeyViews[OneOctavePiano.PREV_NOTE_G] = (View)findViewById(R.id.prev_g);
        pianoKeyViews[OneOctavePiano.PREV_NOTE_G_SHARP] = (View)findViewById(R.id.prev_gs);
        pianoKeyViews[OneOctavePiano.PREV_NOTE_A] =  (View)findViewById(R.id.prev_a);
        pianoKeyViews[OneOctavePiano.PREV_NOTE_A_SHARP] = (View)findViewById(R.id.prev_as);
        pianoKeyViews[OneOctavePiano.PREV_NOTE_B] =(View)findViewById(R.id.prev_b);

        pianoKeyViews[OneOctavePiano.NOTE_C] = (View)findViewById(R.id.c);
        pianoKeyViews[OneOctavePiano.NOTE_C_SHARP] =  (View)findViewById(R.id.cs);
        pianoKeyViews[OneOctavePiano.NOTE_D] = (View)findViewById(R.id.d);
        pianoKeyViews[OneOctavePiano.NOTE_D_SHARP] =(View)findViewById(R.id.ds);
        pianoKeyViews[OneOctavePiano.NOTE_E] = (View)findViewById(R.id.e);
        pianoKeyViews[OneOctavePiano.NOTE_F] = (View)findViewById(R.id.f);
        pianoKeyViews[OneOctavePiano.NOTE_F_SHARP] = (View)findViewById(R.id.fs);
        pianoKeyViews[OneOctavePiano.NOTE_G] = (View)findViewById(R.id.g);
        pianoKeyViews[OneOctavePiano.NOTE_G_SHARP] = (View)findViewById(R.id.gs);
        pianoKeyViews[OneOctavePiano.NOTE_A] = (View)findViewById(R.id.a);
        pianoKeyViews[OneOctavePiano.NOTE_A_SHARP] = (View)findViewById(R.id.as);
        pianoKeyViews[OneOctavePiano.NOTE_B] = (View)findViewById(R.id.b);

        pianoKeyViews[OneOctavePiano.NEXT_NOTE_C] = (View)findViewById(R.id.next_c);
        pianoKeyViews[OneOctavePiano.NEXT_NOTE_C_SHARP] = (View)findViewById(R.id.next_cs);
        pianoKeyViews[OneOctavePiano.NEXT_NOTE_D] = (View)findViewById(R.id.next_d);
        pianoKeyViews[OneOctavePiano.NEXT_NOTE_D_SHARP] = (View)findViewById(R.id.next_ds);
        pianoKeyViews[OneOctavePiano.NEXT_NOTE_E] = (View)findViewById(R.id.next_e);

        for(View a: pianoKeyViews)
            a.setClickable(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Melody.sp = new SoundPool.Builder().setMaxStreams(24).build();
            Instrument.sp = new SoundPool.Builder().setMaxStreams(24).build();
        }
        else{
            Melody.sp = new SoundPool(24, AudioManager.STREAM_MUSIC,0);
            Instrument.sp = new SoundPool(24, AudioManager.STREAM_MUSIC,0);
        }

        melody = new Melody( this, mainSignature, melodyArray);

        String mainSignature = melody.getMainSignature();
        final OneOctavePiano keyboard;
        keyboard = new OneOctavePiano(mainSignature, this, pianoKeyViews);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    melody.play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(View a: pianoKeyViews)
                    a.setClickable(true);
            }
        });

        for( View v : pianoKeyViews){

            v.setOnTouchListener(new View.OnTouchListener() {

                long time1, time2;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    PianoKey pressedKey;
                    pressedKey = (PianoKey)keyboard.getVibratorFromView(v);

                    Note playedNote = pressedKey.getCorrespondingNote();


                    if(event.getAction() == android.view.MotionEvent.ACTION_DOWN ) {
                        time1 = System.currentTimeMillis();
                        System.out.println("TIIIIIIIIIIIIIIIIIIME 1    " + time1);
                        keyboard.playNote( pressedKey);

                        nextNoteInTheMelody = (NoteWithBeats) melody.nextNote();

                            if( playedNote.getName().equals(nextNoteInTheMelody.getName()) ){
                                v.setBackgroundColor(getResources().getColor(R.color.day_green_primary));
                                if( melody.isMelodyFinished()){
                                    textViewGZ.setText("CONGRATULATIONS");
                                    melody.refresh();
                                    waitSeconds(1);
                                }
                            }
                            else{
                                v.setBackgroundColor(getResources().getColor(R.color.falseNote));
                                melody.refresh();
                                textViewGZ.setText("TRY AGAIN");
                                waitSeconds(1);
                            }

                    }
                    else if(event.getAction() == android.view.MotionEvent.ACTION_UP) {
                        time2 = System.currentTimeMillis();
                        System.out.println("TIIIIIIIIIIIIIIIIIIME 2    " + time2 + "    " + time1);

                        keyboard.stopPlayingNote(pressedKey);

                        if( playedNote.getName().equals(nextNoteInTheMelody.getName())){
                            if( (time2 - time1) > nextNoteInTheMelody.getBeats() * 1000 + 150){
                                System.out.println(time2 - time1);
                                System.out.println(nextNoteInTheMelody.getBeats() * 1000 + 150);
                                Toast.makeText(getApplicationContext(),"Shorter!",Toast.LENGTH_SHORT).show();
                            }
                            else if( time2 - time1 < nextNoteInTheMelody.getBeats() * 1000 - 150){
                                System.out.println(time2 - time1);
                                System.out.println(nextNoteInTheMelody.getBeats() * 1000 + 150);
                                Toast.makeText(getApplicationContext(),"Longer!",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                // do nothing
                            }
                        }


                        if(pressedKey.getCorrespondingNote().getName().charAt(1) == '#')
                            v.setBackground(getResources().getDrawable(R.drawable.black_button));
                        else
                            v.setBackground(getResources().getDrawable(R.drawable.white_button));


                    }
                    return true;
                }
            });
        }
    }

    private void waitSeconds(int x){
        new CountDownTimer(x*1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                textViewGZ.setText("");
            }

        }.start();
    }

}