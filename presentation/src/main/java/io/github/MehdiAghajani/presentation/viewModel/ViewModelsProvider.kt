package io.github.MehdiAghajani.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.MehdiAghajani.presentation.di.qualifier.ViewModelKey
import io.github.MehdiAghajani.presentation.viewModel.splash.SplashViewModel

@Module
abstract class ViewModelsProvider {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel
}