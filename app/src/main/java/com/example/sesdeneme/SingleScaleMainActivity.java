package com.example.sesdeneme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//TODO bu sayfa backend düzenlenecek
//TODO çıkan seslerin doğruluğu kontrol edilecek

public class SingleScaleMainActivity extends AppCompatActivity {
    private static final int NOTE_C = 0;
    private static final int NOTE_C_SHARP = 1;
    private static final int NOTE_D = 2;
    private static final int NOTE_D_SHARP = 3;
    private static final int NOTE_E = 4;
    private static final int NOTE_F = 5;
    private static final int NOTE_F_SHARP = 6;
    private static final int NOTE_G = 7;
    private static final int NOTE_G_SHARP = 8;
    private static final int NOTE_A = 9;
    private static final int NOTE_A_SHARP = 10;
    private static final int NOTE_B = 11;
    private View a, aSharp, b, c, cSharp, d, dSharp, e, f, fSharp, g, gSharp, random;
    private SoundPool soundPool;
    TextView currentNote, text_streak;
    int streak;
    int currentNoteId;
    private int sound_a, sound_b, sound_c, sound_d, sound_e, sound_f, sound_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_scale_main);

        //initialize
        a = (View)findViewById(R.id.btn_a);
        aSharp=(View)findViewById(R.id.btn_a_sharp);
        b = (View)findViewById(R.id.btn_b);
        c = (View)findViewById(R.id.btn_c);
        cSharp = (View)findViewById(R.id.btn_c_sharp);
        d = (View)findViewById(R.id.btn_d);
        dSharp = (View)findViewById(R.id.btn_d_sharp);
        e = (View)findViewById(R.id.btn_e);
        f = (View)findViewById(R.id.btn_f);
        fSharp = (View)findViewById(R.id.btn_f_sharp);
        g = (View)findViewById(R.id.btn_g);
        gSharp = (View)findViewById(R.id.btn_g_sharp);
        random = (Button)findViewById(R.id.btn_random_note);
        currentNote = (TextView)findViewById(R.id.text_currentNote);
        text_streak = (TextView)findViewById(R.id.text_streak);

        View[] noteTiles = new View[12];
        noteTiles[NOTE_C] = c;
        noteTiles[NOTE_C_SHARP] = cSharp;
        noteTiles[NOTE_D] = d;
        noteTiles[NOTE_D_SHARP] = dSharp;
        noteTiles[NOTE_E] = e;
        noteTiles[NOTE_F] = f;
        noteTiles[NOTE_F_SHARP] = fSharp;
        noteTiles[NOTE_G] = g;
        noteTiles[NOTE_G_SHARP] = gSharp;
        noteTiles[NOTE_A] = a;
        noteTiles[NOTE_A_SHARP] = aSharp;
        noteTiles[NOTE_B] = b;

        streak = 0; //current streak is 0
        text_streak.setText("STREAK: " + streak);


        //creating soundPool
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else{
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }
        //initializing notes
        sound_a = soundPool.load(this, R.raw.a3, 1);
        sound_b = soundPool.load(this, R.raw.b3, 1);
        sound_c = soundPool.load(this, R.raw.c3, 1);
        sound_d = soundPool.load(this, R.raw.d3, 1);
        sound_e = soundPool.load(this, R.raw.e3, 1);
        sound_f = soundPool.load(this, R.raw.f3, 1);
        sound_g = soundPool.load(this, R.raw.g3, 1);

        final int[] notes = new int[12];
        notes[NOTE_C] = sound_c;
        notes[NOTE_C_SHARP] = sound_c;
        notes[NOTE_D] = sound_d;
        notes[NOTE_D_SHARP] = sound_d;
        notes[NOTE_E] = sound_e;
        notes[NOTE_F] = sound_f;
        notes[NOTE_F_SHARP] = sound_f;
        notes[NOTE_G] = sound_g;
        notes[NOTE_G_SHARP] = sound_g;
        notes[NOTE_A] = sound_a;
        notes[NOTE_A_SHARP] = sound_a;
        notes[NOTE_B] = sound_b;

        /*Plays a random note.
          -Saves the note in the char note
         */
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int random_index = (int) (Math.random() * 11);
                soundPool.play(notes[random_index], 1, 1, 0, 0, 1);
                         long time = System.currentTimeMillis();

                         String note = getNameOfNote(random_index);
                         currentNote.setText(note);
                         currentNoteId = random_index;
                         random.setClickable(true);
            }

            private String getNameOfNote(int random_index) {
                if(random_index==NOTE_C)
                    return "C";
                if(random_index==NOTE_C_SHARP)
                    return "C#";
                if(random_index==NOTE_D)
                    return "D";
                if(random_index==NOTE_D_SHARP)
                    return "D#";
                if(random_index==NOTE_E)
                    return "E";
                if(random_index==NOTE_F)
                    return "F";
                if(random_index==NOTE_F_SHARP)
                    return "F#";
                if(random_index==NOTE_G)
                    return "G";
                if(random_index==NOTE_G_SHARP)
                    return "G#";
                if(random_index==NOTE_A)
                    return "A";
                if(random_index==NOTE_A_SHARP)
                    return "A#";
                if(random_index==NOTE_B)
                    return "B";

                return "";
            }
        });


        for(int i=0; i<12; i++){
            final View pressedTile = noteTiles[i];
            pressedTile.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {
                    int noteIndex = getNoteIndexOfCurrentTile(pressedTile.getId());
                    soundPool.play(notes[noteIndex], 1, 1, 0, 0, 1);
                    //Toast.makeText(SingleScaleMainActivity.this, "NOTE: A", Toast.LENGTH_SHORT).show();
                    if(currentNoteId == noteIndex)
                    {
                        updateStreak( true);
                        //Changes color to green for 1 second after that changes it to default.
                        pressedTile.setBackgroundColor(getResources().getColor(R.color.trueNote));
                        new CountDownTimer(1000, 1000)
                        {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                if(pressedTile.getId() == aSharp.getId() || pressedTile.getId() == cSharp.getId()
                                    || pressedTile.getId() == fSharp.getId() || pressedTile.getId() == dSharp.getId()
                                        || pressedTile.getId() == gSharp.getId())
                                    pressedTile.setBackgroundResource(R.drawable.black_button);
                                else
                                    pressedTile.setBackgroundResource(R.drawable.white_button);
                            }
                        }.start();
                    }
                    else
                    {
                        updateStreak( false);
                        //Changes color to red for 1 second after that changes it to default.
                        pressedTile.setBackgroundColor(getResources().getColor(R.color.falseNote));
                        new CountDownTimer(1000, 1000)
                        {

                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                if(pressedTile.getId() == aSharp.getId() || pressedTile.getId() == cSharp.getId()
                                        || pressedTile.getId() == fSharp.getId() || pressedTile.getId() == dSharp.getId()
                                        || pressedTile.getId() == gSharp.getId())
                                    pressedTile.setBackgroundResource(R.drawable.black_button);
                                else
                                    pressedTile.setBackgroundResource(R.drawable.white_button);
                            }
                        }.start();
                    }
                }

                private int getNoteIndexOfCurrentTile(int id) {

                    if(id == a.getId())
                        return NOTE_A;
                    if(id==b.getId())
                        return NOTE_B;
                    if(id == c.getId())
                        return NOTE_C;
                    if(id==d.getId())
                        return NOTE_D;
                    if(id == e.getId())
                        return NOTE_E;
                    if(id==f.getId())
                        return NOTE_F;
                    if(id == g.getId())
                        return NOTE_G;
                    if(id==cSharp.getId())
                        return NOTE_C_SHARP;
                    if(id==dSharp.getId())
                        return NOTE_D_SHARP;
                    if(id==fSharp.getId())
                        return NOTE_F_SHARP;
                    if(id==gSharp.getId())
                        return NOTE_G_SHARP;
                    if(id==aSharp.getId())
                        return NOTE_A_SHARP;

                    return -1;
                }
            });
        }

    }

    /*
    Function for updating the streak text view.
    -If the pressed button is wrong Note, resets the streak.
    -If the pressed button is right Note, incremenents the streak by 1.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void updateStreak(boolean trueNote)
    {
        TextView textView = (TextView) findViewById(R.id.text_streak);
        boolean rightNote = true;
        boolean falseNote = false;
        if(Boolean.compare(trueNote, rightNote) == 0)
        {
            this.streak++;
            textView.setText("STREAK: " + this.streak);
        }
        else
        {
            this.streak = 0;
            textView.setText("STREAK: " + streak);
        }
    }
}
