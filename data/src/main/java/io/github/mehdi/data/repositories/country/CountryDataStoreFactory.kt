package io.github.mehdi.data.repositories.country

import javax.inject.Inject

class CountryDataStoreFactory
@Inject constructor(private val remote: CountryDataRemote)
{
    suspend fun getCountryList() = remote.getCountryList()
}