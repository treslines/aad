package br.com.programadordeelite.gdc.codelab.userinterface.menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.codelab.util.toast
import br.com.programadordeelite.gdc.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_order -> {
                navTo(R.id.action_menuFragment_to_orderFragment)
                return true
            }
            R.id.action_status -> {
                toast(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                toast(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                toast(getString(R.string.action_contact_message))
                return true
            }
            else -> Unit
        }
        return super.onOptionsItemSelected(item)
    }
}