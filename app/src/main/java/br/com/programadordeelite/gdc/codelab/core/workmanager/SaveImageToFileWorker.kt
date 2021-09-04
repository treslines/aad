package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class SaveImageToFileWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    private val title = "Blurred Image"
    private val dateFormatter = SimpleDateFormat(
        "yyyy.MM.dd 'at' HH:mm:ss z",
        Locale.getDefault()
    )

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