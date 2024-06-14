package com.energyaustralia.codingtestsample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidTest {


        @Test
        fun useAppContext() {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            Assert.assertEquals("com.energyaustralia.codingtestsample", appContext.packageName)
        }

        @Test

        fun ValidateContentDisplay() {
            val scenario = ActivityScenario.launch(MainActivity::class.java)
            Thread.sleep(15000)
            Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.titleTextView)))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            scenario.close()

        }

        @Test
        fun testScrollDown() {
            val scenario = ActivityScenario.launch(MainActivity::class.java)
            Thread.sleep(15000)
            val elementIds =
                listOf(Espresso.onData(ViewMatchers.withId(R.id.titleTextView)))
            elementIds.last().perform(ViewActions.swipeDown())
            Espresso.onData(ViewMatchers.withId(R.id.titleTextView))
                .atPosition(5).perform(ViewActions.scrollTo())

        }

    }