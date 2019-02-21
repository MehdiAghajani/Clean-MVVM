package io.github.mehdi.remote

import io.github.mehdi.remote.mapper.CountryMapper
import io.github.mehdi.remote.restful.APIs
import io.github.mehdi.data.model.DataCountryModel
import io.github.mehdi.data.repositories.country.CountryDataRemote
import javax.inject.Inject

class CountryDataRemoteRepositoryImpl
@Inject constructor(
    private val apIs: APIs,
    private val mapper: CountryMapper
)
    : CountryDataRemote
{
    override suspend fun getCountryList(): List<DataCountryModel> {
        return mapper.mapFromRemote(apIs.getCountryList().await())
    }

}