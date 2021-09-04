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
class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // LAYOUT EM PASTA CHAMADA: XML
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}