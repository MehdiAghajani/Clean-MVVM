package io.github.mehdi.clean.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mehdi.clean.ui.main.home.HomeFragment

@Module
abstract class MainActivityFragmentProvider {
    @ContributesAndroidInjector
    internal abstract fun provideHomeFragment(): HomeFragment
}