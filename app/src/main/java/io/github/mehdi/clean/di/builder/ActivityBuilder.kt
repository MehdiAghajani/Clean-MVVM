package io.github.mehdi.clean.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mehdi.clean.ui.main.MainActivity
import io.github.mehdi.clean.ui.main.MainActivityFragmentProvider
import io.github.mehdi.clean.ui.splash.SplashActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [MainActivityFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity
}