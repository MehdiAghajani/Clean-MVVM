package io.github.mehdi.domain.repository

import io.github.mehdi.domain.model.DomainCountryModel

interface CountryRepository {

    suspend fun getCountryList(): List<DomainCountryModel>
}