package at.mg.androidstudiosandbox;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.mg.androidstudiosandbox.activities.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Markus on 11.12.2015.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityTest {


    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void changeText() {
        onView(withId(R.id.home_edit)).perform(typeText("HALLO"), closeSoftKeyboard());

        onView(withId(R.id.home_edit)).check(matches(withText("HALLO")));
    }


}
