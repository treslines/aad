package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.WorkInfo
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentBlurBinding
import com.bumptech.glide.Glide

class BlurFragment : Fragment(R.layout.fragment_blur) {

    private lateinit var viewModel: BlurViewModel
    private lateinit var binding: FragmentBlurBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlurBinding.bind(view)

        // ATUALIZADO: Obtenho o viewmodel
        // viewModel = ViewModelProviders.of(this).get(BlurViewModel::class.java)
        viewModel = ViewModelProvider(this).get(BlurViewModel::class.java)

        // pego a uri da imagem selecionada que passei como argumento na tela anterior
        val imageUriExtra = arguments?.getString(KEY_IMAGE_URI)

        viewModel.setImageUri(imageUriExtra)
        viewModel.imageUri?.let { imageUri ->
            Glide.with(this).load(imageUri).into(binding.imageView)
        }

        binding.goButton.setOnClickListener { viewModel.applyBlur(blurLevel) }

        // Setup view output image file button
        binding.seeFileButton.setOnClickListener {
            viewModel.outputUri?.let { currentUri ->
                val actionView = Intent(Intent.ACTION_VIEW, currentUri)
                actionView.resolveActivity(requireActivity().packageManager)?.run {
                    startActivity(actionView)
                }
            }
        }

        // Hookup the Cancel button
        binding.cancelButton.setOnClickListener { viewModel.cancelWork() }

        viewModel.outputWorkInfos.observe(requireActivity(), workInfosObserver())
    }

    private fun workInfosObserver(): Observer<List<WorkInfo>> {
        return Observer { listOfWorkInfo ->

            // se nao tiver info, continuar sem fazer nada
            if (listOfWorkInfo.isNullOrEmpty()) {
                return@Observer
            }

            // We only care about the one output status.
            // Every continuation has only one worker tagged TAG_OUTPUT
            val workInfo = listOfWorkInfo[0]

            if (workInfo.state.isFinished) {
                showWorkFinished() // exibir botão

                // Normally this processing, which is not directly related to drawing views on
                // screen would be in the ViewModel. For simplicity we are keeping it here.
                val outputImageUri = workInfo.outputData.getString(KEY_IMAGE_URI)

                // se existir um arquivo com blur, exibir botão "See File"
                if (!outputImageUri.isNullOrEmpty()) {
                    viewModel.setOutputUri(outputImageUri as String)
                    binding.seeFileButton.visibility = View.VISIBLE
                }
            } else {
                showWorkInProgress() // do contrário exibir loading
            }
        }
    }

    // UI control
    private fun showWorkInProgress() {
        with(binding) {
            progressBar.visibility = View.VISIBLE
            cancelButton.visibility = View.VISIBLE
            goButton.visibility = View.GONE
            seeFileButton.visibility = View.GONE
        }
    }

    private fun showWorkFinished() {
        with(binding) {
            progressBar.visibility = View.GONE
            cancelButton.visibility = View.GONE
            goButton.visibility = View.VISIBLE
        }
    }

    private val blurLevel: Int
        get() =
            when (binding.radioBlurGroup.checkedRadioButtonId) {
                R.id.radio_blur_lv_1 -> 1
                R.id.radio_blur_lv_2 -> 2
                R.id.radio_blur_lv_3 -> 3
                else -> 1
            }
}