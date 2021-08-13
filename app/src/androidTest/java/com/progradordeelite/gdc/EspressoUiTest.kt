package com.progradordeelite.gdc

import android.content.Intent
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.programadordeelite.gdc.MainActivity
import br.com.programadordeelite.gdc.R
//import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResult
//import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResultBaseUtils.matchesCheckNames
//import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResultUtils.matchesViews
//import org.hamcrest.Matchers.`is`
//import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class EspressoUiTest {

    init {
        val configurator = AccessibilityChecks.enable()
//        configurator.setThrowExceptionFor(AccessibilityCheckResult.AccessibilityCheckResultType.ERROR)
//        configurator.setRunChecksFromRootView(true)
//        configurator.setSuppressingResultMatcher(
//            allOf(
//                matchesCheckNames(`is`("TextContrastViewCheck")),
//                matchesViews(withId(R.id.btnAdd))
//            )
//        )
    }

    @Test
    fun testIncrement(){
        // launch desired activity - OLD WAY NO CASO DE VC ENCONTRAR ISSO POR AI
        IntentsTestRule(MainActivity::class.java).launchActivity(Intent())
        Espresso.onView(withId(R.id.codelab_accessibility)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Apertou 1 vez!")))
    }

    @Test
    fun testIncrementNew(){
        val scenario = launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.codelab_accessibility)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Apertou 1 vez!")))
        Espresso.onView(withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Apertou 2 vez!")))
        scenario.onActivity { activity ->
            println("se quiser chamar algum metodo da activity, faz aqui!") // do some stuff with the Activity
            // exemplo: activity.onBackPressed()
        }
        scenario.close() // hightly recomended otherwise activity will remain open
    }

    @get:Rule
    val rule = activityScenarioRule<MainActivity>()

    @Test
    fun testIncrementNewWithRuleEvenBetterSinceItClosesScenarioAutomatically(){
        val scenario = rule.scenario
        scenario.onActivity { activity ->
            println("se quiser chamar algum metodo da activity, faz aqui!") // do some stuff with the Activity
            // exemplo: activity.onBackPressed()
        }
        Espresso.onView(withId(R.id.codelab_accessibility)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Aperta lá no botão!")))
        Espresso.onView(withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Apertou 1 vez!")))
        Espresso.onView(withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Apertou 2 vez!")))
        Espresso.onView(withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textAdd)).check(matches(withText("Apertou 3 vez!")))
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("br.com.programadordeelite.gdc", appContext.packageName)
    }
}