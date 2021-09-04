package br.com.programadordeelite.gdc.codelab.datamanagement.sharedprefs

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentSharedPrefBinding

class SharedPrefFragment : Fragment(R.layout.fragment_shared_pref) {

    companion object {
        const val COUNT_KEY = "COUNT_KEY"
        const val COLOR_KEY = "COLOR_KEY"
        const val SHARED_PREFS = "com.softsuit.codelab.datamanagement.sharedprefs"
    }

    private lateinit var binding: FragmentSharedPrefBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSharedPrefBinding.bind(view)
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}