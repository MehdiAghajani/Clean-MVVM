package io.github.MehdiAghajani.data.repositories.country

import io.github.MehdiAghajani.data.model.DataCountryModel

interface CountryDataRemote
{
    suspend fun getCountryList(): List<DataCountryModel>
}