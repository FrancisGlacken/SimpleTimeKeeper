package com.deltorostudios.punchclockmockup2.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.deltorostudios.punchclockmockup2.Util.FormatMillisIntoTimer;
import com.deltorostudios.punchclockmockup2.R;
import com.deltorostudios.punchclockmockup2.ViewModels.TimerViewModel;


public class TimerFragment extends Fragment {

    long initialTime, displayTime;
    TimerViewModel timerViewModel;
    Handler handler;
    public TimerFragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_timer, container, false);

        // Initialize views/viewModel
        handler = new Handler();
        final FormatMillisIntoTimer form = new FormatMillisIntoTimer();
        final TextView timerView = view.findViewById(R.id.textTimer);
        ToggleButton startPauseButton = view.findViewById(R.id.buttonStartPause);
        timerViewModel = ViewModelProviders.of(this).get(TimerViewModel.class);

        timerViewModel.getObservedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                timerView.setText(form.FormatMillisIntoHMS(aLong));
            }
        });

        // toggleButton onClick
        startPauseButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isRunning) {
                if (isRunning) {
                    if (displayTime > 0) {
                        initialTime = SystemClock.elapsedRealtime() - displayTime;
                    } else {
                        initialTime = SystemClock.elapsedRealtime();
                    }
                    handler.postDelayed(runTimer, 0);
                } else {
                    handler.removeCallbacks(runTimer);
                }

            }
        });


        return view;
    }

    public Runnable runTimer = new Runnable() {
        @Override
        public void run() {
            displayTime = SystemClock.elapsedRealtime() - initialTime;
            timerViewModel.setTimer(displayTime);
            handler.postDelayed(runTimer, 0);
        }
    };
}
