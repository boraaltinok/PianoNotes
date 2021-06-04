package com.example.sesdeneme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration
    private Button a, b, c, d, e, f, random;

    private SoundPool soundPool;
    TextView currentNote, text_streak;
    int streak;
    private int sound_a, sound_b, sound_c, sound_d, sound_e, sound_f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        a = (Button)findViewById(R.id.a);
        b = (Button)findViewById(R.id.b);
        c = (Button)findViewById(R.id.c);
        d = (Button)findViewById(R.id.d);
        e = (Button)findViewById(R.id.e);
        f = (Button)findViewById(R.id.f);
        random = (Button)findViewById(R.id.btn_random_note);
        currentNote = (TextView)findViewById(R.id.text_currentNote);
        text_streak = (TextView)findViewById(R.id.text_streak);

        //setting buttons backgrounds to custom and text colors to white
        a.setBackgroundResource(R.drawable.custom_button);
        a.setTextColor(Color.WHITE);
        b.setBackgroundResource(R.drawable.custom_button);
        b.setTextColor(Color.WHITE);
        c.setBackgroundResource(R.drawable.custom_button);
        c.setTextColor(Color.WHITE);
        d.setBackgroundResource(R.drawable.custom_button);
        d.setTextColor(Color.WHITE);
        e.setBackgroundResource(R.drawable.custom_button);
        e.setTextColor(Color.WHITE);
        f.setBackgroundResource(R.drawable.custom_button);
        f.setTextColor(Color.WHITE);
        random.setBackgroundResource(R.drawable.custom_button);
        random.setTextColor(Color.WHITE);
        text_streak.setBackgroundResource(R.drawable.custom_button);
        text_streak.setTextColor(Color.WHITE);

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

        final int[] notes = {sound_a, sound_b, sound_c, sound_d, sound_e, sound_f};

        /*Plays a random note.
          -Saves the note in the char note
         */
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int random_index = (int) (Math.random() * 6);
                soundPool.play(notes[random_index], 1, 1, 0, 0, 1);
                         long time = System.currentTimeMillis();
                         //while (System.currentTimeMillis() != time + 1000) {
                         //}
                         char note = 'A';
                         int i = 0;
                         while( i != random_index)
                         {
                             i++;
                             note++;
                         }
                        String str = String.valueOf(note);

                        currentNote.setText(str);
                        random.setClickable(true);
            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundPool.play(sound_a, 1, 1, 0, 0, 1);
                Toast.makeText(MainActivity.this, "NOTE: A", Toast.LENGTH_SHORT).show();
                if(currentNote.getText().toString().equals("A"))
                {
                    updateStreak( true);
                    //Changes color to green for 1 second after that changes it to default.
                    a.setBackgroundColor(getResources().getColor(R.color.trueNote));
                    new CountDownTimer(1000, 1000)
                    {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            a.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }
                else
                {
                    updateStreak( false);
                    //Changes color to red for 1 second after that changes it to default.
                    a.setBackgroundColor(getResources().getColor(R.color.falseNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            a.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundPool.play(sound_b, 1, 1, 0, 0, 1);
                Toast.makeText(MainActivity.this, "NOTE: B", Toast.LENGTH_SHORT).show();
                if(currentNote.getText().toString().equals("B"))
                {
                    updateStreak( true);
                    //Changes color to green for 1 second after that changes it to default.
                    b.setBackgroundColor(getResources().getColor(R.color.trueNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            b.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }
                else
                {
                    updateStreak( false);
                    //Changes color to red for 1 second after that changes it to default.
                    b.setBackgroundColor(getResources().getColor(R.color.falseNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            b.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c, 1, 1, 0, 0, 1);
                Toast.makeText(MainActivity.this, "NOTE: C", Toast.LENGTH_SHORT).show();
                if(currentNote.getText().toString().equals("C"))
                {
                    updateStreak( true);
                    //Changes color to red for 1 second after that changes it to default.
                    c.setBackgroundColor(getResources().getColor(R.color.trueNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            c.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }
                else
                {
                    updateStreak( false);
                    //Changes color to green for 1 second after that changes it to default.
                    c.setBackgroundColor(getResources().getColor(R.color.falseNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            c.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }



            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d, 1, 1, 0, 0, 1);
                Toast.makeText(MainActivity.this, "NOTE: D", Toast.LENGTH_SHORT).show();
                if(currentNote.getText().toString().equals("D"))
                {
                    updateStreak( true);

                    d.setBackgroundColor(getResources().getColor(R.color.trueNote));
                    //Changes color to red for 1 second after that changes it to default.
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            d.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }
                else
                {
                    updateStreak( false);
                    //Changes color to green for 1 second after that changes it to default.
                    d.setBackgroundColor(getResources().getColor(R.color.falseNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            d.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }

            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e, 1, 1, 0, 0, 1);
                Toast.makeText(MainActivity.this, "NOTE: E", Toast.LENGTH_SHORT).show();
                if(currentNote.getText().toString().equals("E"))
                {
                    updateStreak( true);
                    //Changes color to green for 1 second after that changes it to default.
                    e.setBackgroundColor(getResources().getColor(R.color.trueNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            e.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }
                else
                {
                    updateStreak( false);

                    //Changes color to red for 1 second after that changes it to default.
                    e.setBackgroundColor(getResources().getColor(R.color.falseNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            e.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }

            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f, 1, 1, 0, 0, 1);
                Toast.makeText(MainActivity.this, "NOTE: F", Toast.LENGTH_SHORT).show();
                if(currentNote.getText().toString().equals("F"))
                {
                    updateStreak(true);

                    //Changes color to green for 1 second after that changes it to default.
                    f.setBackgroundColor(getResources().getColor(R.color.trueNote));
                    new CountDownTimer(1000, 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            f.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }
                else
                {
                    updateStreak(false);

                    //Changes color to red for 1 second after that changes it to default.
                    f.setBackgroundColor(getResources().getColor(R.color.falseNote));
                    new CountDownTimer(1000 , 1000)
                    {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            f.setBackgroundResource(R.drawable.custom_button);
                        }
                    }.start();
                }

            }
        });
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
