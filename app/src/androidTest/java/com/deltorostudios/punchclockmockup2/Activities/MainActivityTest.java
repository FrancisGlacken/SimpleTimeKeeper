package com.deltorostudios.punchclockmockup2.Activities;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.deltorostudios.punchclockmockup2.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void init() {
        mainRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void DoViewsExistTest() {
        onView(withId(R.id.testView)).perform(replaceText("GET MONEY"));
        onView(withId(R.id.addButton)).perform(click());

        pressBack();
        onView(withId(R.id.mainRecyclerView)).check(matches(isDisplayed()));

    }

    @Test
    public void CanWeGetItToSwipeToSecondTab() {
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
        onView(withId(R.id.viewPager)).perform(swipeRight());
    }
}