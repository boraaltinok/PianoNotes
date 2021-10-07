package com.example.sesdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.sesdeneme.Models.Instrument;
import com.example.sesdeneme.Models.OneOctavePiano;

public class FreePianoActivity extends AppCompatActivity {

    private View[] keyboard1;
    private View[] keyboard2;
    private View[] keyboard3;

    private GestureDetectorCompat mDetector;

    private Context context;

    private Instrument c3keyboard, c4keyboard, c5keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_piano);

        keyboard1 = new View[24];

        keyboard1[OneOctavePiano.PREV_NOTE_F] = (View)findViewById(R.id.top_f);
        keyboard1[OneOctavePiano.PREV_NOTE_F_SHARP] = (View)findViewById(R.id.top_fs);
        keyboard1[OneOctavePiano.PREV_NOTE_G] = (View)findViewById(R.id.top_g);
        keyboard1[OneOctavePiano.PREV_NOTE_G_SHARP] = (View)findViewById(R.id.top_gs);
        keyboard1[OneOctavePiano.PREV_NOTE_A] =  (View)findViewById(R.id.top_a);
        keyboard1[OneOctavePiano.PREV_NOTE_A_SHARP] = (View)findViewById(R.id.top_as);
        keyboard1[OneOctavePiano.PREV_NOTE_B] =(View)findViewById(R.id.top_b);

        keyboard1[OneOctavePiano.NOTE_C] = (View)findViewById(R.id.top_c);
        keyboard1[OneOctavePiano.NOTE_C_SHARP] =  (View)findViewById(R.id.top_cs);
        keyboard1[OneOctavePiano.NOTE_D] = (View)findViewById(R.id.top_d);
        keyboard1[OneOctavePiano.NOTE_D_SHARP] =(View)findViewById(R.id.top_ds);
        keyboard1[OneOctavePiano.NOTE_E] = (View)findViewById(R.id.top_e);
        keyboard1[OneOctavePiano.NOTE_F] = (View)findViewById(R.id.top_f2);
        keyboard1[OneOctavePiano.NOTE_F_SHARP] = (View)findViewById(R.id.top_fs2);
        keyboard1[OneOctavePiano.NOTE_G] = (View)findViewById(R.id.top_g2);
        keyboard1[OneOctavePiano.NOTE_G_SHARP] = (View)findViewById(R.id.top_gs2);
        keyboard1[OneOctavePiano.NOTE_A] = (View)findViewById(R.id.top_a2);
        keyboard1[OneOctavePiano.NOTE_A_SHARP] = (View)findViewById(R.id.top_as2);
        keyboard1[OneOctavePiano.NOTE_B] = (View)findViewById(R.id.top_b2);

        keyboard1[OneOctavePiano.NEXT_NOTE_C] = (View)findViewById(R.id.top_c2);
        keyboard1[OneOctavePiano.NEXT_NOTE_C_SHARP] = (View)findViewById(R.id.top_cs2);
        keyboard1[OneOctavePiano.NEXT_NOTE_D] = (View)findViewById(R.id.top_d2);
        keyboard1[OneOctavePiano.NEXT_NOTE_D_SHARP] = (View)findViewById(R.id.top_ds2);
        keyboard1[OneOctavePiano.NEXT_NOTE_E] = (View)findViewById(R.id.top_e2);

        keyboard2 = new View[24];

        keyboard2[OneOctavePiano.PREV_NOTE_F] = (View)findViewById(R.id.mid_f);
        keyboard2[OneOctavePiano.PREV_NOTE_F_SHARP] = (View)findViewById(R.id.mid_fs);
        keyboard2[OneOctavePiano.PREV_NOTE_G] = (View)findViewById(R.id.mid_g);
        keyboard2[OneOctavePiano.PREV_NOTE_G_SHARP] = (View)findViewById(R.id.mid_gs);
        keyboard2[OneOctavePiano.PREV_NOTE_A] =  (View)findViewById(R.id.mid_a);
        keyboard2[OneOctavePiano.PREV_NOTE_A_SHARP] = (View)findViewById(R.id.mid_as);
        keyboard2[OneOctavePiano.PREV_NOTE_B] =(View)findViewById(R.id.mid_b);

        keyboard2[OneOctavePiano.NOTE_C] = (View)findViewById(R.id.mid_c);
        keyboard2[OneOctavePiano.NOTE_C_SHARP] =  (View)findViewById(R.id.mid_cs);
        keyboard2[OneOctavePiano.NOTE_D] = (View)findViewById(R.id.mid_d);
        keyboard2[OneOctavePiano.NOTE_D_SHARP] =(View)findViewById(R.id.mid_ds);
        keyboard2[OneOctavePiano.NOTE_E] = (View)findViewById(R.id.mid_e);
        keyboard2[OneOctavePiano.NOTE_F] = (View)findViewById(R.id.mid_f2);
        keyboard2[OneOctavePiano.NOTE_F_SHARP] = (View)findViewById(R.id.mid_fs2);
        keyboard2[OneOctavePiano.NOTE_G] = (View)findViewById(R.id.mid_g2);
        keyboard2[OneOctavePiano.NOTE_G_SHARP] = (View)findViewById(R.id.mid_gs2);
        keyboard2[OneOctavePiano.NOTE_A] = (View)findViewById(R.id.mid_a2);
        keyboard2[OneOctavePiano.NOTE_A_SHARP] = (View)findViewById(R.id.mid_as2);
        keyboard2[OneOctavePiano.NOTE_B] = (View)findViewById(R.id.mid_b2);

        keyboard2[OneOctavePiano.NEXT_NOTE_C] = (View)findViewById(R.id.mid_c2);
        keyboard2[OneOctavePiano.NEXT_NOTE_C_SHARP] = (View)findViewById(R.id.mid_cs2);
        keyboard2[OneOctavePiano.NEXT_NOTE_D] = (View)findViewById(R.id.mid_d2);
        keyboard2[OneOctavePiano.NEXT_NOTE_D_SHARP] = (View)findViewById(R.id.mid_ds2);
        keyboard2[OneOctavePiano.NEXT_NOTE_E] = (View)findViewById(R.id.mid_e2);

        keyboard3 = new View[24];

        keyboard3[OneOctavePiano.PREV_NOTE_F] = (View)findViewById(R.id.bot_f);
        keyboard3[OneOctavePiano.PREV_NOTE_F_SHARP] = (View)findViewById(R.id.bot_fs);
        keyboard3[OneOctavePiano.PREV_NOTE_G] = (View)findViewById(R.id.bot_g);
        keyboard3[OneOctavePiano.PREV_NOTE_G_SHARP] = (View)findViewById(R.id.bot_gs);
        keyboard3[OneOctavePiano.PREV_NOTE_A] =  (View)findViewById(R.id.bot_a);
        keyboard3[OneOctavePiano.PREV_NOTE_A_SHARP] = (View)findViewById(R.id.bot_as);
        keyboard3[OneOctavePiano.PREV_NOTE_B] =(View)findViewById(R.id.bot_b);

        keyboard3[OneOctavePiano.NOTE_C] = (View)findViewById(R.id.bot_c);
        keyboard3[OneOctavePiano.NOTE_C_SHARP] =  (View)findViewById(R.id.bot_cs);
        keyboard3[OneOctavePiano.NOTE_D] = (View)findViewById(R.id.bot_d);
        keyboard3[OneOctavePiano.NOTE_D_SHARP] =(View)findViewById(R.id.bot_ds);
        keyboard3[OneOctavePiano.NOTE_E] = (View)findViewById(R.id.bot_e);
        keyboard3[OneOctavePiano.NOTE_F] = (View)findViewById(R.id.bot_f2);
        keyboard3[OneOctavePiano.NOTE_F_SHARP] = (View)findViewById(R.id.bot_fs2);
        keyboard3[OneOctavePiano.NOTE_G] = (View)findViewById(R.id.bot_g2);
        keyboard3[OneOctavePiano.NOTE_G_SHARP] = (View)findViewById(R.id.bot_gs2);
        keyboard3[OneOctavePiano.NOTE_A] = (View)findViewById(R.id.bot_a2);
        keyboard3[OneOctavePiano.NOTE_A_SHARP] = (View)findViewById(R.id.bot_as2);
        keyboard3[OneOctavePiano.NOTE_B] = (View)findViewById(R.id.bot_b2);

        keyboard3[OneOctavePiano.NEXT_NOTE_C] = (View)findViewById(R.id.bot_c2);
        keyboard3[OneOctavePiano.NEXT_NOTE_C_SHARP] = (View)findViewById(R.id.bot_cs2);
        keyboard3[OneOctavePiano.NEXT_NOTE_D] = (View)findViewById(R.id.bot_d2);
        keyboard3[OneOctavePiano.NEXT_NOTE_D_SHARP] = (View)findViewById(R.id.bot_ds2);
        keyboard3[OneOctavePiano.NEXT_NOTE_E] = (View)findViewById(R.id.bot_e2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Instrument.sp = new SoundPool.Builder().setMaxStreams(72).build();
        }
        else{
            Instrument.sp = new SoundPool(72, AudioManager.STREAM_MUSIC,0);
        }

        context = this;

        c3keyboard = new OneOctavePiano("C3", context, keyboard3);
        c4keyboard = new OneOctavePiano("C4", context, keyboard2);
        c5keyboard = new OneOctavePiano("C5", context, keyboard1);

        int soundID1;
        int soundID2;
        int soundID3;

        /*for( int i = 0; i < OneOctavePiano.numberOfKeys; i++){
            soundID1 = Instrument.sp.load( context, c5keyboard.get( i).getSoundFile(), 1);
            c5keyboard.getKeyByIndex( i).setSoundID(soundID1);
            soundID2 = Instrument.sp.load( context, c4keyboard.getKeyByIndex( i).getSoundFile(), 1);
            c4keyboard.getKeyByIndex( i).setSoundID(soundID2);
            soundID3 = Instrument.sp.load( context, c3keyboard.getKeyByIndex( i).getSoundFile(), 1);
            c3keyboard.getKeyByIndex( i).setSoundID(soundID3);
        }*/

        for( View v : keyboard1){


            v.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCC");
                    if(event.getAction() == android.view.MotionEvent.ACTION_DOWN ) {
                        c5keyboard.playNote( c5keyboard.getVibratorFromView(v));
                        System.out.println("aAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

                    }
                    else if(event.getAction() == android.view.MotionEvent.ACTION_UP) {
                        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                        c5keyboard.stopPlayingNote(c5keyboard.getVibratorFromView(v));

                    }
                    return true;

                }
            });
        }

        for( View v : keyboard2){

            v.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCC");
                    if(event.getAction() == android.view.MotionEvent.ACTION_DOWN ) {
                        c4keyboard.playNote( c4keyboard.getVibratorFromView(v));
                        System.out.println("aAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

                    }
                    else if(event.getAction() == android.view.MotionEvent.ACTION_UP) {
                        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                        c4keyboard.stopPlayingNote(c4keyboard.getVibratorFromView(v));

                    }
                    return true;
                }
            });
        }

        for( View v : keyboard3){

            v.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCC");
                    if(event.getAction() == android.view.MotionEvent.ACTION_DOWN ) {
                        c3keyboard.playNote( c3keyboard.getVibratorFromView(v));
                        System.out.println("aAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

                    }
                    else if(event.getAction() == android.view.MotionEvent.ACTION_UP) {
                        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                        c3keyboard.stopPlayingNote(c3keyboard.getVibratorFromView(v));

                    }
                    return true;
                }
            });
        }
    }

}