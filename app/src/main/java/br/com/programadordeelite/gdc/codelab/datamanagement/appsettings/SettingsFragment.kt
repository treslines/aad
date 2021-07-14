package br.com.programadordeelite.gdc.codelab.datamanagement.appsettings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import br.com.programadordeelite.gdc.R


const val KEY_PREF_SIGNATURE = "signature"
const val KEY_PREF_REPLY = "reply"
const val KEY_PREF_SYNC = "sync"
const val KEY_PREF_ATTACHMENT = "attachment"

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}