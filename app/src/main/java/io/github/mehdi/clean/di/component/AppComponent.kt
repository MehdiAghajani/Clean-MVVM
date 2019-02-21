package io.github.mehdi.clean.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.github.mehdi.clean.app.CleanApplication
import io.github.mehdi.clean.di.builder.ActivityBuilder
import io.github.mehdi.clean.di.module.AppModule
import io.github.mehdi.clean.di.builder.ViewModelBuilder
import io.github.mehdi.remote.di.module.NetworkModule
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