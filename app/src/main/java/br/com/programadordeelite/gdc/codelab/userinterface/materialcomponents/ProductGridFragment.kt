package br.com.programadordeelite.gdc.codelab.userinterface.materialcomponents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentProductGridBinding

class ProductGridFragment : Fragment(R.layout.fragment_product_grid) {

    private lateinit var binding: FragmentProductGridBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}