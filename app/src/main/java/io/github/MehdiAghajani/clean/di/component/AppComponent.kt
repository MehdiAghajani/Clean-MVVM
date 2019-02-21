package io.github.MehdiAghajani.clean.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.github.MehdiAghajani.clean.app.CleanApplication
import io.github.MehdiAghajani.clean.di.builder.ActivityBuilder
import io.github.MehdiAghajani.clean.di.module.AppModule
import io.github.MehdiAghajani.presentation.di.builder.ViewModelBuilder
import io.github.MehdiAghajani.remote.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityBuilder::class,
        ViewModelBuilder::class,
        NetworkModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: CleanApplication)
}