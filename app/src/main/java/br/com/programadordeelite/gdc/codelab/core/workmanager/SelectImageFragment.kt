package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentSelectImageBinding
import timber.log.Timber

class SelectImageFragment : Fragment(R.layout.fragment_select_image) {

    // ATUALIZADO
    companion object {
        private const val KEY_PERMISSIONS_GRANTED = "KEY_PERMISSIONS_GRANTED"
        private const val KEY_PERMISSIONS_REQUEST_COUNT = "KEY_PERMISSIONS_REQUEST_COUNT"
        private const val MAX_NUMBER_REQUEST_PERMISSIONS = 2
    }

    private var permissionRequestCount: Int = 0
    private lateinit var binding: FragmentSelectImageBinding
    private lateinit var launcher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // deve ser definido ou no onAttach ou onCreate
        launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
            handleImageRequestResult(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSelectImageBinding.bind(view)

        // recuperando o ultimo estado caso o usuário rotacione o aparelho
        savedInstanceState?.let {
            permissionRequestCount = it.getInt(KEY_PERMISSIONS_REQUEST_COUNT, 0)
            userHasPermission = it.getBoolean(KEY_PERMISSIONS_GRANTED, false)
        }

        // asseguresse que o usuário tens as permissões necessárias
        requestPermissionsOnlyTwice(userHasPermission)

        // abrir o file chooser
        binding.selectImage.setOnClickListener {
            launcher.launch("image/*")
        }
    }

    private var userHasPermission = false
    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    private fun requestPermissionsOnlyTwice(hasPermissionsAlready: Boolean) {
        if(!hasPermissionsAlready){
            if (permissionRequestCount < MAX_NUMBER_REQUEST_PERMISSIONS) {
                permissionRequestCount += 1
                val permissionChecker = registerForActivityResult(
                    ActivityResultContracts.RequestMultiplePermissions()
                ) { permissionsAccepted ->
                    val permissionsIdentified = permissionsAccepted.all{it.key in permissions}
                    val permissionsGrant = permissionsAccepted.all{it.value == true}
                    if(permissionsIdentified && permissionsGrant) {
                        permissionRequestCount = 0
                        userHasPermission = true
                    }
                }
                if(!userHasPermission){
                    permissionChecker.launch(permissions)
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    R.string.set_permissions_in_settings,
                    Toast.LENGTH_LONG
                ).show()
                binding.selectImage.isEnabled = false
            }
        }
    }

    private fun handleImageRequestResult(uri: Uri) {
        // navegar para proxima etapa onde exibimos as opções de blur
        findNavController().navigate(R.id.blurFragment, bundleOf(Pair(KEY_IMAGE_URI, uri.toString())))
    }

    // salvar estados em caso que o usuario rotacione o aparelho
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_PERMISSIONS_REQUEST_COUNT, permissionRequestCount)
        outState.putBoolean(KEY_PERMISSIONS_GRANTED, userHasPermission)
    }
}