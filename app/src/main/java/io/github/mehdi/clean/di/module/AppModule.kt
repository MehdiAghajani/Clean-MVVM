package io.github.mehdi.clean.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.mehdi.cache.preference.PreferenceImpl
import io.github.mehdi.data.repositories.storage.StorageCache
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideLocalStorage(context: Context): StorageCache {
        return PreferenceImpl(context)
    }
}