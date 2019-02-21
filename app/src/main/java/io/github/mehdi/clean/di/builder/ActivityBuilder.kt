package io.github.mehdi.clean.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mehdi.clean.ui.SplashActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity
}