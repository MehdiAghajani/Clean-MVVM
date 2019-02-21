package io.github.mehdi.clean.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.github.mehdi.presentation.presenters.ViewModelsProvider
import io.github.mehdi.presentation.presenters.base.AppViewModelFactory

@Module(
    includes = [
        NavigatorBuilder::class,
        ViewModelsProvider::class
    ]
)
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}