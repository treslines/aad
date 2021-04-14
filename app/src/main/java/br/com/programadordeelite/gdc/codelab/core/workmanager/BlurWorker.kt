package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.content.Context
import android.graphics.BitmapFactory
import androidx.work.Worker
import androidx.work.WorkerParameters
import br.com.programadordeelite.gdc.R
import timber.log.Timber

class BlurWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val appContext = applicationContext
        makeStatusNotification("Blurring image", appContext)
        return try {
            val picture = BitmapFactory.decodeResource(appContext.resources, R.drawable.test)
            val output = blurBitmap(picture, appContext)
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