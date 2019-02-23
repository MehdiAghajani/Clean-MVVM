package io.github.mehdi.data.repositories.country

import io.github.mehdi.data.model.DataCountryModel
import kotlinx.coroutines.Deferred

interface CountryDataRemote
{
    suspend fun getCountryList(): Deferred<List<DataCountryModel>>
}