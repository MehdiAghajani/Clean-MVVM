package io.github.data.repositories.country

import javax.inject.Inject

class CountryDataStoreFactory
@Inject constructor(private val remote: CountryDataRemote)
{
    fun getCountryList() = remote.getCountryList()
}