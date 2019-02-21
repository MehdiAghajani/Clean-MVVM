package io.github.mehdi.presentation.presenters

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.mehdi.presentation.di.qualifier.ViewModelKey
import io.github.mehdi.presentation.presenters.main.MainViewModel
import io.github.mehdi.presentation.presenters.main.home.HomeViewModel
import io.github.mehdi.presentation.presenters.splash.SplashViewModel

@Module
abstract class ViewModelsProvider {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}