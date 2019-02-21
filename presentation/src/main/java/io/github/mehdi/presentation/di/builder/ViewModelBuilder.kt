package io.github.mehdi.presentation.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.github.mehdi.presentation.viewModel.ViewModelsProvider
import io.github.mehdi.presentation.viewModel.base.AppViewModelFactory

@Module(
    includes = [
        ViewModelsProvider::class
    ]
)
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}