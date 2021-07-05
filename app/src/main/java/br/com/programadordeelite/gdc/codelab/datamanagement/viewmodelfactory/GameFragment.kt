package br.com.programadordeelite.gdc.codelab.datamanagement.viewmodelfactory

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.codelab.util.toast
import br.com.programadordeelite.gdc.databinding.FragmentGameBinding

class GameFragment : Fragment(R.layout.fragment_game) {
    private lateinit var binding: FragmentGameBinding

    private lateinit var viewModel: GameViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)
        Log.i("GameFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame() }

        updateScoreText()
        updateWordText()

    }

    /** Methods for button click handlers **/

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }
    private fun onCorrect() {
        viewModel.onCorrect()
        updateScoreText()
        updateWordText()
    }

    /** Methods for updating the UI **/
    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }

    private fun onEndGame() {
        gameFinished()
    }

    /**
     * Called when the game is finished
     * ATENCAO: Para entender melhor directions, veja isso aqui:
     * https://developer.android.com/guide/navigation/navigation-navigate#groovy
     */
    private fun gameFinished() {
        toast("Game has just finished")
        // bacana para passar actions embora tbm possivel por bundles
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score
        // outra maneira de navegar
        NavHostFragment.findNavController(this).navigate(action)
    }
}