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
    @RequiresApi(Build.VERSION_CODES.P)
    override fun doWork(): Result {
        val appContext = applicationContext
        makeStatusNotification("Blurring image", appContext)
        return try {
            val resourceUri = inputData.getString(KEY_IMAGE_URI)
            val pic = MediaStore.Images.Media.getBitmap(ctx.contentResolver, Uri.parse(resourceUri))
            val output = blurBitmap(pic, appContext)
            // Write bitmap to a temp file
            val outputUri = writeBitmapToFile(appContext, output)
            makeStatusNotification("Output is $outputUri", appContext)
            Result.success()
        } catch (throwable: Throwable) {
            Timber.e(throwable, "Error applying blur")
            Result.failure()
        }
    }
}