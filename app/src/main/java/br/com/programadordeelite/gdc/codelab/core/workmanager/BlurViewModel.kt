package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.work.*

// Modelo que retem as informações e faz a mediação entre workers e observa os estados
class BlurViewModel(application: Application) : AndroidViewModel(application) {

    internal var imageUri: Uri? = null
    internal var outputUri: Uri? = null
    private val workManager = WorkManager.getInstance(application)
    //internal val outputWorkInfos: LiveData<List<WorkInfo>>

    init {
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA AS AULAS:                             |
        // | https://youtu.be/5AGWzq9JpYo                                                    |
        // | https://youtu.be/MJpeoRopmgw                                                    |
        // | https://youtu.be/vGwr9XZ8xDY                                                    |
        // +---------------------------------------------------------------------------------+
    }

}