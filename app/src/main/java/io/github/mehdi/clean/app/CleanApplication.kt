package io.github.mehdi.clean.app

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.github.mehdi.clean.BuildConfig
import io.github.mehdi.clean.di.component.DaggerAppComponent
import javax.inject.Inject

class CleanApplication: Application(), HasActivityInjector
{
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        initDebugModeValues()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    private fun initDebugModeValues() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}