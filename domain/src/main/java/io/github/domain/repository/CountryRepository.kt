package io.github.domain.repository

import io.github.domain.model.DomainCountryModel

interface CountryRepository {

    suspend fun getCountryList(): List<DomainCountryModel>
}