package br.com.programadordeelite.gdc.codelab.datamanagement.appsettings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import br.com.programadordeelite.gdc.R

// PREFERÊNCIA TRABALHA COM PARES CHAVE / VALOR
const val KEY_PREF_SIGNATURE = "signature"
const val KEY_PREF_REPLY = "reply"
const val KEY_PREF_SYNC = "sync"
const val KEY_PREF_ATTACHMENT = "attachment"

// MENU DE PREFERÊNCIAS É UM RECURSO ESPECIAL
// FAVORITA E DA TE SUBSCRIBE, PRA NA HORA DA PROVA, NAO FICAR APERRIADO! :)
class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // LAYOUT EM PASTA CHAMADA: XML
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}