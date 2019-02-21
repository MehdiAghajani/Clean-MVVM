package io.github.mehdi.clean.di.builder

import dagger.Binds
import dagger.Module
import io.github.mehdi.clean.ui.splash.SplashNavigatorImpl
import io.github.mehdi.presentation.presenters.splash.SplashNavigator

@Module
interface NavigatorBuilder {
    @Binds
    fun bindSplashNavigator(navigator: SplashNavigatorImpl): SplashNavigator
}