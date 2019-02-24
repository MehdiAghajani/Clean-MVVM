package io.github.mehdi.clean.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.github.mehdi.clean.di.bindings.ModuleImplBindings
import io.github.mehdi.data.di.DomainImplBindings
import io.github.mehdi.presentation.presenters.ViewModelsProvider
import io.github.mehdi.presentation.presenters.base.AppViewModelFactory
import io.github.mehdi.remote.di.module.DataRemoteImplBindings

@Module(
    includes = [
        NavigatorBuilder::class,
        ModuleImplBindings::class,
        DomainImplBindings::class,
        DataRemoteImplBindings::class,
        ViewModelsProvider::class
    ]
)
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}