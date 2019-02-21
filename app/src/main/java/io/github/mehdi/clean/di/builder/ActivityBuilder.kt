package io.github.mehdi.clean.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mehdi.clean.ui.splash.SplashActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [NavigatorBuilder::class])
    internal abstract fun bindSplashActivity(): SplashActivity
}