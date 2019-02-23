package io.github.mehdi.domain.repository

import io.github.mehdi.domain.model.DomainCountryModel
import kotlinx.coroutines.Deferred

interface CountryRepository {

    suspend fun getCountryList(): Deferred<List<DomainCountryModel>>
}