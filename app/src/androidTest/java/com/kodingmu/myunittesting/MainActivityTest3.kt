package com.kodingmu.myunittesting


import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest3 {

    private val dummyVolume = "504.0"
    private val dummyCircumference = "2016.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest3() {
    }

    @Test
    fun getCircumference() {
        Espresso.onView(ViewMatchers.withId(R.id.edt_length))
            .perform(ViewActions.typeText(dummyLength), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edt_width))
            .perform(ViewActions.typeText(dummyWidth), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edt_height))
            .perform(ViewActions.typeText(dummyHeight), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.btn_calculate_circumference))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btn_calculate_circumference)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.tv_result))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyCircumference)))
    }

    @Test
    fun getSurfaceArea() {
        Espresso.onView(ViewMatchers.withId(R.id.edt_length))
            .perform(ViewActions.typeText(dummyLength), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_width))
            .perform(ViewActions.typeText(dummyWidth), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_height))
            .perform(ViewActions.typeText(dummyHeight), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_calculate_surface_area))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_calculate_surface_area)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_result))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummySurfaceArea)))
    }


    @Test
    fun getVolume() {
        Espresso.onView(ViewMatchers.withId(R.id.edt_length))
            .perform(ViewActions.typeText(dummyLength), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_width))
            .perform(ViewActions.typeText(dummyWidth), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_height))
            .perform(ViewActions.typeText(dummyHeight), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_calculate_volume))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_calculate_volume)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.tv_result)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_result))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyVolume)))
    }

    @Test
    fun emptyInput() {
        Espresso.onView(ViewMatchers.withId(R.id.edt_length))
            .perform(ViewActions.typeText(emptyInput), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.edt_length))
            .check(ViewAssertions.matches(ViewMatchers.hasErrorText(fieldEmpty)))
        Espresso.onView(ViewMatchers.withId(R.id.edt_length))
            .perform(ViewActions.typeText(dummyLength), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_width))
            .perform(ViewActions.typeText(emptyInput), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.edt_width))
            .check(ViewAssertions.matches(ViewMatchers.hasErrorText(fieldEmpty)))
        Espresso.onView(ViewMatchers.withId(R.id.edt_width))
            .perform(ViewActions.typeText(dummyWidth), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.edt_height))
            .perform(ViewActions.typeText(emptyInput), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.edt_height))
            .check(ViewAssertions.matches(ViewMatchers.hasErrorText(fieldEmpty)))
        Espresso.onView(ViewMatchers.withId(R.id.edt_height))
            .perform(ViewActions.typeText(dummyHeight), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_save)).perform(ViewActions.click())
    }
}
