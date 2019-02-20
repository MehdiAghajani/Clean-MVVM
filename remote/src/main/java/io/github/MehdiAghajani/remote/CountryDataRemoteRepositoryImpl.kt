package io.github.MehdiAghajani.remote

import io.github.MehdiAghajani.remote.mapper.CountryMapper
import io.github.MehdiAghajani.remote.restful.APIs
import io.github.MehdiAghajani.data.model.DataCountryModel
import io.github.MehdiAghajani.data.repositories.country.CountryDataRemote
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