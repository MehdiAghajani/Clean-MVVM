package io.github.domain.repository

import io.github.domain.model.DomainCountryModel
import kotlinx.coroutines.Deferred

interface CountryRepository {

    fun getCountryList(): Deferred<List<DomainCountryModel>>
}