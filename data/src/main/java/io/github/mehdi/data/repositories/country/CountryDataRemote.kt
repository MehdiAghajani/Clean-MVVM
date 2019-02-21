package io.github.mehdi.data.repositories.country

import io.github.mehdi.data.model.DataCountryModel

interface CountryDataRemote
{
    suspend fun getCountryList(): List<DataCountryModel>
}