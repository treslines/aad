package br.com.programadordeelite.gdc.codelab.debugging.calc

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

// +-------------------------------------------------------------------------------------+
// | Caso vc tenha algum problema para rodar os testes este link pode ajudar a resolver  |
// +-------------------------------------------------------------------------------------+
// https://stackoverflow.com/questions/47926382/how-to-configure-shorten-command-line-method-for-whole-project-in-intellij

@RunWith(JUnit4::class)
class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    // +---------------------------------------------------------------------------------+
    // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
    // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
    // +---------------------------------------------------------------------------------+
}