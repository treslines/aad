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
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}