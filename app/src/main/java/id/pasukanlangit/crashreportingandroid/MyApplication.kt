package id.pasukanlangit.crashreportingandroid

import android.app.Application
import id.pasukanlangit.crashreportingandroid.BuildConfig
import timber.log.Timber

open class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }else{
            Timber.plant(ReleaseTree())
        }
    }
}