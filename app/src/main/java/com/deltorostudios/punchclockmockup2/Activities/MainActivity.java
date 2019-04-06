package com.deltorostudios.punchclockmockup2.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deltorostudios.punchclockmockup2.Fragments.HomeFragment;
import com.deltorostudios.punchclockmockup2.Fragments.TimerFragment;
import com.deltorostudios.punchclockmockup2.R;

public class MainActivity extends AppCompatActivity {
    //Todo: testing github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter( new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    // SectionPagerAdapter?
    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                default:
                    return new TimerFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0:
                    return "First Tab";
                case 1:
                default:
                    return "Second Tab";
            }
        }
    }

//    // Runnable for the timer
//    public Runnable mainRunnable = new Runnable() {
//
//        public void run() {
//            seconds = (SystemClock.elapsedRealtime() - timeOnClick) / 1000;
//            myHandler.postDelayed(mainRunnable, 1000L);
//        }
//
//    };
//
//    // StartPause button
//    public void StartPause(View view) {
//
//       if (buttonStartPause.isChecked()) {
//
//           // Use an if statement to make timeonClick == etc. only happen once?
//           if (timeOnClick == 0) { timeOnClick = SystemClock.elapsedRealtime(); }
//           myHandler.postDelayed(mainRunnable, 1000L);
//           Toast toast = Toast.makeText(this, R.string.toast_message_started, Toast.LENGTH_SHORT);
//           toast.show();
//
//
//       } else if (!buttonStartPause.isChecked()) {
//
//           myHandler.removeCallbacks(mainRunnable);
//           Toast toast = Toast.makeText(this, R.string.toast_message_paused, Toast.LENGTH_SHORT);
//           toast.show();
//       }
//    }
//    // Stop button
//    public void Stop(View view) {
//        myHandler.removeCallbacks(mainRunnable);
//    }
}
