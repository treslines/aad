package br.com.programadordeelite.gdc.codelab.datamanagement.appsettings

import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.codelab.util.toast
import br.com.programadordeelite.gdc.databinding.FragmentAppSettingsBinding


class AppSettingsFragment : Fragment(R.layout.fragment_app_settings) {

    lateinit var binding: FragmentAppSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAppSettingsBinding.bind(view)
        setHasOptionsMenu(true) // IMPORTANTE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_settings, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                navTo(R.id.settingsFragment)
                return true
            }
            else -> Unit
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(requireContext())
        val assinatura = sharedPref.getString(KEY_PREF_SIGNATURE, "!") ?: ""
        if(assinatura.isNotEmpty()) toast(assinatura)
        val resposta = sharedPref.getString(KEY_PREF_REPLY, "!") ?: ""
        if(resposta.isNotEmpty()) toast(resposta)
        val sincronizacao = sharedPref.getBoolean(KEY_PREF_SYNC, false)
        if(sincronizacao) toast("sincronizacao ativada")
        val anexos = sharedPref.getBoolean(KEY_PREF_ATTACHMENT, false)
        if(anexos) toast("anexos ativados")
    }
}