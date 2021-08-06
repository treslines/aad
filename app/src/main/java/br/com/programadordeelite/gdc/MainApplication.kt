package br.com.programadordeelite.gdc

import android.app.Application
import br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview.WordRepository
import br.com.programadordeelite.gdc.codelab.datamanagement.roomwithview.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber

class MainApplication : Application() {

    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { WordRoomDatabase.getDatabase(this@MainApplication, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) // Timber é o "novo" Logger recomendado pela google
        }
    }
}