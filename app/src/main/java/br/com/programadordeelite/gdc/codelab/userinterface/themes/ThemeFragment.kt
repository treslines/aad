package br.com.programadordeelite.gdc.codelab.userinterface.themes

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentThemeBinding

class ThemeFragment : Fragment(R.layout.fragment_theme) {

    private var scoreTeam1 = 0
    private var scoreTeam2 = 0
    private val stateScore1 = "Team 1 Score"
    private val stateScore2 = "Team 2 Score"

    private lateinit var binding: FragmentThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentThemeBinding.bind(view)

        if (savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt(stateScore1)
            scoreTeam2 =savedInstanceState.getInt(stateScore2)
            binding.score1.text = scoreTeam1.toString()
            binding.score2.text = scoreTeam2.toString()
        }

        binding.decreaseButtonTeam1.setOnClickListener {
            binding.score1.text = (--scoreTeam1).toString()
        }
        binding.decreaseButtonTeam2.setOnClickListener {
            binding.score2.text = (--scoreTeam2).toString()
        }
        binding.increaseButtonTeam1.setOnClickListener {
            binding.score1.text = (++scoreTeam1).toString()
        }
        binding.increaseButtonTeam2.setOnClickListener {
            binding.score2.text = (++scoreTeam2).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(stateScore1, scoreTeam1)
        outState.putInt(stateScore2, scoreTeam2)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.theme_menu, menu)
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.night_mode) {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            // Recreate the activity for the theme change to take effect.
            requireActivity().recreate()
        }
        return true
    }
}