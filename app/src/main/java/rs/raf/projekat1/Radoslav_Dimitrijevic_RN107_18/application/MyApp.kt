package rs.raf.projekat1.Radoslav_Dimitrijevic_RN107_18

import android.app.Application
import timber.log.Timber

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}