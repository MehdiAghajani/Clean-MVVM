package io.github.mehdi.presentation.presenters

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.mehdi.presentation.di.qualifier.ViewModelKey
import io.github.mehdi.presentation.presenters.splash.SplashViewModel

@Module
abstract class ViewModelsProvider {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel
}