package com.progradordeelite.gdc

import android.content.Context
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.*
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import br.com.programadordeelite.gdc.MainActivity
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.debugging.calc.Calculator
import junit.framework.TestCase.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user_navigation.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.*


/**
 * QUER APRENDER A TESTAR UI COM ESPRESSO?
 * >>> VEJA O VIDEO DE ACESSIBILIDADE
 */
@RunWith(AndroidJUnit4::class)
@MediumTest
@ExperimentalCoroutinesApi
class NavigationGraphTest {

    @Test
    fun testNavigationFromMainFragmentToCodelabToastSnake() = runBlockingTest {

        var navControl: NavController? = null

        val activityScenario = launchActivity<MainActivity>()
        activityScenario.onActivity {
            navControl = Navigation.findNavController(it,R.id.nav_host_fragment)
        }

        // WHEN - QUANDO USUÁRIO CLICAR NO BOTÃO PARA O CODELAB DE TOAST E SNACK
        Espresso.onView(withId(R.id.codelab_toast_snake)).perform(ViewActions.click())

        // 1°) FORMA DE VERIFICAR SE O APP NAVEGOU PARA A TELA EM QUESTÃO
        Espresso.onView(withId(R.id.toast)).check(ViewAssertions.matches(
            ViewMatchers.withContentDescription("tostando"))
        )

        // 2°) DE VERIFICAR NAVEGACAO
        assertThat(navControl!!.currentDestination?.id,`is`(equalTo(R.id.toastSnakeFragment)))

        val calculator = mock(Calculator::class.java)
        // IMAGINE QUE AQUI SERIA UMA CHAMADA PARA O BACKEND, POREM VC NAO TEM O BACKEND AINDA
        // AI NESSE CASO VC PODERIA RETORNAR 200 PARA SUCESSO (CODIGO HTTP DE SUCESSO)
        Mockito.`when`(calculator.add(anyDouble(),anyDouble())).thenReturn(4.0)

        // VERIFICA RESULTADO
        val userCount = calculator.add(2.0,1.0)
        assertEquals(4.0, userCount)

        // VERIFICA COMPORTAMENTO, NESSE CASO QUE O METODO ADD FOI CHAMADO
        verify(calculator).add(anyDouble(), anyDouble())
    }
}