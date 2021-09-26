package br.com.programadordeelite.gdc.codelab.animation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.codelab.util.setVisible
import br.com.programadordeelite.gdc.databinding.FragmentPulseExplodeBinding

class PulseExplodeFragment : Fragment(R.layout.fragment_pulse_explode) {
    private lateinit var binding: FragmentPulseExplodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPulseExplodeBinding.bind(view)

        // ==================================================
        //  PULSE ANIMATION               -------------------
        // ==================================================
        startPulseAnim(binding.buttonPulseBackgroundAnimation)

        // ==================================================
        //  EXPLODE ANIMATION             -------------------
        // ==================================================
        binding.buttonPulse.setOnClickListener {
            binding.buttonPulse.setVisible(false)
            startExplodeAnim(binding.buttonPulseBackgroundAnimation, ::showNextScreen)
        }
    }

    private fun showNextScreen() {
        navTo(R.id.pulseExplodeDestinationFragment_with_custom_animation)
    }

    private fun startPulseAnim(view: View) = scaleDown(view)
    private fun scaleUp(view: View) {
        view.animate()
            .scaleX(SCALE_UP_VALUE)
            .scaleY(SCALE_UP_VALUE)
            .setDuration(PULSE_DURATION)
            .withEndAction { kotlin.run { scaleDown(view) } }
            .start()
    }

    private fun scaleDown(view: View) {
        view.animate()
            .scaleX(SCALE_DOWN_VALUE)
            .scaleY(SCALE_DOWN_VALUE)
            .setDuration(PULSE_DURATION)
            .withEndAction { kotlin.run { scaleUp(view) } }
            .start()
    }

    private fun startExplodeAnim(view: View, endAction: () -> Unit) = shrink(view, endAction)
    private fun shrink(view: View, endAction: () -> Unit) {
        // if any previous animation is running, make sure it is canceled first
        view.animation?.let {
            it.cancel()
            it.reset()
        }
        view.animate()
            .scaleX(SHRINK_VALUE)
            .scaleY(SHRINK_VALUE)
            .setDuration(SHRINK_DURATION)
            .withEndAction { kotlin.run { explode(view, endAction) } }
            .start()
    }

    private fun explode(view: View, endAction: () -> Unit) {
        view.animate()
            .scaleX(EXPLODE_VALUE)
            .scaleY(EXPLODE_VALUE)
            .setDuration(EXPLODE_DURATION)
            .withEndAction { kotlin.run { endAction() } }
            .start()
    }

    companion object AnimProps {
        private const val PULSE_DURATION = 1500L
        private const val SHRINK_DURATION = 600L
        private const val EXPLODE_DURATION = 300L
        private const val SCALE_DOWN_VALUE = 0.9f
        private const val SCALE_UP_VALUE = 1f
        private const val SHRINK_VALUE = 0.3f
        private const val EXPLODE_VALUE = 4f
    }
}