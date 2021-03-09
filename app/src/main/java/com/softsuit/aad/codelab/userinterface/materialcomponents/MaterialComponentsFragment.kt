package com.softsuit.aad.codelab.userinterface.materialcomponents

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import com.softsuit.aad.R
import com.softsuit.aad.codelab.util.navTo
import com.softsuit.aad.databinding.FragmentMaterialComponentsBinding
import kotlinx.android.synthetic.main.fragment_material_components.*


class MaterialComponentsFragment : Fragment(R.layout.fragment_material_components) {
    private lateinit var binding: FragmentMaterialComponentsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMaterialComponentsBinding.bind(view)

        binding.nextButton.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.shr_error_password)
            } else {
                password_text_input.error = null
                navTo(R.id.productGridFragment)
            }
        }

        // Clear the error once more than 8 characters are typed.
        binding.passwordEditText.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = null
            }
            false
        }

    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}