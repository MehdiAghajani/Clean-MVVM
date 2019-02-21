package io.github.MehdiAghajani.presentation.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.github.MehdiAghajani.presentation.viewModel.ViewModelsProvider
import io.github.MehdiAghajani.presentation.viewModel.base.AppViewModelFactory

@Module(
    includes = [
        ViewModelsProvider::class
    ]
)
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}