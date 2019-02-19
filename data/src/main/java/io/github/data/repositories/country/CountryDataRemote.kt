package io.github.data.repositories.country

import io.github.domain.model.DomainCountryModel
import kotlinx.coroutines.Deferred

interface CountryDataRemote
{
    fun getCountryList(): Deferred<List<DomainCountryModel>>
}