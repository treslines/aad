package br.com.programadordeelite.gdc.codelab.debugging.calc

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentCalcBinding
import timber.log.Timber
import java.lang.IllegalArgumentException

// LINK PARA VC SE APROFUNDAR NOS ESTUDOS
// https://developer.android.com/studio/command-line/adb.html
class CalcFragment : Fragment(R.layout.fragment_calc) {

    private val calculator by lazy { Calculator() }
    private lateinit var binding: FragmentCalcBinding
    private val logTag by lazy { CalcFragment::class.java.simpleName }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalcBinding.bind(view)
        binding.operationAddBtn.setOnClickListener { compute(Calculator.Operator.ADD) }
        binding.operationSubBtn.setOnClickListener { compute(Calculator.Operator.SUB) }
        binding.operationDivBtn.setOnClickListener { compute(Calculator.Operator.DIV) }
        binding.operationMulBtn.setOnClickListener { compute(Calculator.Operator.MUL) }
    }

    private fun compute(operation: Calculator.Operator) {
        try {
            val operandOne = binding.operandOneEditText.text.toString().toDouble()
            val operandTwo = binding.operandTwoEditText.text.toString().toDouble()
            binding.operationResultTextView.setText(
                when (operation) {
                    Calculator.Operator.ADD -> calculator.add(operandOne, operandTwo).toString()
                    Calculator.Operator.SUB -> calculator.sub(operandOne, operandTwo).toString()
                    Calculator.Operator.MUL -> calculator.mul(operandOne, operandTwo).toString()
                    Calculator.Operator.DIV -> try {
                        val division = calculator.div(operandOne, operandTwo)
                        if(division.isFinite()) division.toString() else throw IllegalArgumentException("Illegal Division")
                    } catch (iae: IllegalArgumentException) {
                        Timber.i("IllegalArgumentException") // Timber sem exception
                        Log.e(logTag, "IllegalArgumentException", iae) // para exemplificar o uso de Log
                        getString(R.string.computationError)
                    }
                }
            )
        } catch (nfe: NumberFormatException) {
            Timber.e(nfe, "NumberFormatException") // para exemplificar o uso do timber - com exception
            binding.operationResultTextView.setText(getString(R.string.computationError))
            return
        }
    }
}