package io.github.mehdi.data.di

import dagger.Binds
import dagger.Module
import io.github.mehdi.data.repositories.country.CountryDataRepository
import io.github.mehdi.data.repositories.storage.LocalStorageDataStore
import io.github.mehdi.domain.repository.CountryRepository
import io.github.mehdi.domain.repository.LocalStorageRepository

@Module
interface DomainImplBindings {

    @Binds
    fun bindCountryRepository(countryRepository: CountryDataRepository): CountryRepository

    @Binds
    fun bindLocalStorageRepository(localStorageDataStore: LocalStorageDataStore): LocalStorageRepository
}