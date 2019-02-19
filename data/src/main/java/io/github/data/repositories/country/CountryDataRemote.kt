package io.github.data.repositories.country

import io.github.data.model.DataCountryModel

interface CountryDataRemote
{
    suspend fun getCountryList(): List<DataCountryModel>
}