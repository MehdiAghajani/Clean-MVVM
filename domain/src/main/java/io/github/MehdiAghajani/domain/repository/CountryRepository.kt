package io.github.MehdiAghajani.domain.repository

import io.github.MehdiAghajani.domain.model.DomainCountryModel

interface CountryRepository {

    suspend fun getCountryList(): List<DomainCountryModel>
}