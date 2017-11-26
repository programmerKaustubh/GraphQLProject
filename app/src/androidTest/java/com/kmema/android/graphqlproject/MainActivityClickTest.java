package com.kmema.android.graphqlproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kmema on 11/25/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityClickTest {

    @Rule public ActivityTestRule<MainActivity> mMainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickRecyclerView_ChangesFragmenttsInsideContainer()
    {
        onView((withId(R.id.recycleListViewNode))).perform(click());
        onView((withId(R.id.containerLayout))).check(matches(isDisplayed()));
    }
}
