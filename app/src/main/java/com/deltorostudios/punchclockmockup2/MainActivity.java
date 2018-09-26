package com.deltorostudios.punchclockmockup2;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    long seconds, seconds2, timeOnClick;
    public TextView timer;
    public ToggleButton buttonStartPause;
    Handler myHandler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.textTimer);

        buttonStartPause = findViewById(R.id.buttonStartPause);

        timer.setText(R.string.set_timer);
    }



    // Runnable for the timer
    public Runnable mainRunnable = new Runnable() {

        public void run() {

            seconds = (SystemClock.elapsedRealtime() - timeOnClick) / 1000;
            timer.setText(String.format("%02d:%02d:%02d", seconds / 3600, seconds / 60 % 60, seconds % 60));
            myHandler.postDelayed(mainRunnable, 1000L);


        }

    };


    // StartPause button
    public void StartPause(View view) {

       if (buttonStartPause.isChecked()) {

           // Use an if statement to make timeonClick == etc. only happen once?
           if (timeOnClick == 0) { timeOnClick = SystemClock.elapsedRealtime(); }
           myHandler.postDelayed(mainRunnable, 1000L);
           Toast toast = Toast.makeText(this, R.string.toast_message_started, Toast.LENGTH_SHORT);
           toast.show();


       } else if (!buttonStartPause.isChecked()) {

           myHandler.removeCallbacks(mainRunnable);
           Toast toast = Toast.makeText(this, R.string.toast_message_paused, Toast.LENGTH_SHORT);
           toast.show();

       }

    }

    // Stop button
    public void Stop(View view) {
        myHandler.removeCallbacks(mainRunnable);
    }
}
