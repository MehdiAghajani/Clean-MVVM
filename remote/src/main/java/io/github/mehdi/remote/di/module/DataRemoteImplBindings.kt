package io.github.mehdi.remote.di.module

import dagger.Binds
import dagger.Module
import io.github.mehdi.data.repositories.country.CountryDataRemote
import io.github.mehdi.remote.CountryDataRemoteRepositoryImpl

@Module
interface DataRemoteImplBindings {

    @Binds
    fun bindCountryDataRemoteRepository(repository: CountryDataRemoteRepositoryImpl): CountryDataRemote
}