package br.com.programadordeelite.gdc.codelab.datamanagement.appsettings

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
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

    // CRIACÃO DO MENU
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_settings, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // REAGINDO A SELECÃO DO MENU
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

    // OBTENDO VALORES DAS CONFIGURACÕES FEITAS
    override fun onResume() {
        super.onResume()
        // PARTE IMPORTANTE
        val sharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(requireContext())

        val assinatura = sharedPref.getString(KEY_PREF_SIGNATURE, "!") ?: ""
        if(assinatura.isNotEmpty() && assinatura != "Não Definida") toast(assinatura)

        val resposta = sharedPref.getString(KEY_PREF_REPLY, "!") ?: ""
        if(resposta.isNotEmpty()) toast(resposta)

        val sincronizacao = sharedPref.getBoolean(KEY_PREF_SYNC, false)
        if(sincronizacao) toast("sincronizacao ativada")

        val anexos = sharedPref.getBoolean(KEY_PREF_ATTACHMENT, false)
        if(anexos) toast("anexos ativados")
    }
}