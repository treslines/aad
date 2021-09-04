package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.work.Worker
import androidx.work.WorkerParameters
import br.com.programadordeelite.gdc.R
import timber.log.Timber

// worker que vai aplicar o blur
class BlurWorker(private val ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA AS AULAS:                             |
        // | https://youtu.be/5AGWzq9JpYo                                                    |
        // | https://youtu.be/MJpeoRopmgw                                                    |
        // | https://youtu.be/vGwr9XZ8xDY                                                    |
        // +---------------------------------------------------------------------------------+
        TODO("Not yet implemented")
    }
}