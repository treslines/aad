package com.progradordeelite.gdc

//import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResult
//import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResultBaseUtils.matchesCheckNames
//import com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckResultUtils.matchesViews
//import org.hamcrest.Matchers.`is`
//import org.hamcrest.Matchers.allOf
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import br.com.programadordeelite.gdc.MainFragment
import br.com.programadordeelite.gdc.MainFragmentDirections
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.core.toast.ToastSnakeFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * QUER APRENDER A TESTAR UI COM ESPRESSO? >>> VEJA O VIDEO DE ACESSIBILIDADE
 */
@RunWith(AndroidJUnit4::class)
@MediumTest
@ExperimentalCoroutinesApi
class NavigationGraphTest {

    @Test
    fun testNavigationFromMainFragmentToCodelabToastSnake() = runBlockingTest {

        // MOCKANDO O NAVIGATION CONTROLLER
        val navController = mock(NavController::class.java)

        // CRIANDO UM CENARIO DE TESTE
        val scenario = launchFragmentInContainer<MainFragment>(Bundle(), R.style.AppTheme)

        // GIVEN - ADICIONANDO O NAV CONTROLLER MOCKADO AO CENARIO
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        // WHEN - QUANDO USUÁRIO CLICAR NO BOTÃO PARA O CODELAB DE TOAST E SNACK
        Espresso.onView(withId(R.id.codelab_toast_snake)).perform(ViewActions.click())

        // THEN - AI VERIFICA SE O NAVIGATION GRAPH REALMENTE NAVEGOU PARA LÁ
        verify(navController).navigate(MainFragmentDirections.actionMainFragmentToToastSnakeFragment())
    }
}