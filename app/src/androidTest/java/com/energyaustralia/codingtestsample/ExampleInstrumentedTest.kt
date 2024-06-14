package com.energyaustralia.codingtestsample



import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CustomMatcher

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.regex.Matcher

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.energyaustralia.codingtestsample", appContext.packageName)
    }

    @Test

    fun ValidateContentDisplay() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(15000)
        onView(allOf(withId(R.id.titleTextView))).check(matches(isDisplayed()))
        scenario.close()

    }

    @Test
    fun testScrollDown() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(15000)
        val elementIds =
            listOf(onData(withId(R.id.titleTextView)))
          elementIds.last().perform(swipeDown())
       onData(withId(R.id.titleTextView)).atPosition(5).perform(scrollTo())

        }


    }

