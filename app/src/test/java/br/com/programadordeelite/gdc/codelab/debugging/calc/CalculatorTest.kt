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

    @Test
    fun add() = assertThat(calculator.add(1.0, 1.0), `is`(equalTo(2.0)))

    @Test
    fun sub() = assertThat(calculator.sub(1.0, 1.0), `is`(equalTo(0.0)))

    @Test
    fun div() = assertThat(calculator.div(1.0, 1.0), `is`(equalTo(1.0)))

    @Test
    fun mul() = assertThat(calculator.mul(2.0, 1.5), `is`(equalTo(3.0)))

    @Test
    fun add_one_positive_number_to_one_negative_number() = assertThat(calculator.add(-1.0, 2.0), `is`(equalTo(1.0)))

    @Test
    fun `add to floats with decimal values to each other` () = assertThat(calculator.add(1.111, 1.111), `is`(equalTo(2.222)))

    @Test
    fun subWorksWithNegativeResult() = assertThat(calculator.sub(1.0, 17.0), `is`(equalTo(-16.0)))

    @Test
    fun divTwoNumbersThroughZero_ShouldReturn_PositiveInfinity() = assertThat(calculator.div(32.0, 0.0), `is`(equalTo(Double.POSITIVE_INFINITY)))

    @Test
    fun divTwoNumbersZeroNegative() = assertThat(calculator.div(-32.0, 0.0), `is`(equalTo(Double.NEGATIVE_INFINITY)))

    @Test
    fun divTwoNumbersNegative() = assertThat(calculator.div(32.0, -2.0), `is`(equalTo(-16.0)))

    // +--------------------------------------------------------------------------+
    // | Boas práticas: separar testes em blocos de positivos e negativos         |
    // +--------------------------------------------------------------------------+
    @Test
    fun positive__divide_two_numbers_should_succeed() = assertThat(calculator.div(3.0, 2.0), `is`(equalTo(1.5)))

    @Test
    fun negative__divide_number_through_zero_should_return_infinity() = assertThat(calculator.div(10.0, 0.0), `is`(equalTo(Double.POSITIVE_INFINITY)))
}