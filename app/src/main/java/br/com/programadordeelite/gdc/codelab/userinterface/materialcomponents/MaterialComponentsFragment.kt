package br.com.programadordeelite.gdc.codelab.userinterface.materialcomponents

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.navTo
import br.com.programadordeelite.gdc.databinding.FragmentMaterialComponentsBinding
import kotlinx.android.synthetic.main.fragment_material_components.*

class MaterialComponentsFragment : Fragment(R.layout.fragment_material_components) {

    private lateinit var binding: FragmentMaterialComponentsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMaterialComponentsBinding.bind(view) // inicializa o binding

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/qE5lZRSrgxo  |
        // +---------------------------------------------------------------------------------+
    }
}