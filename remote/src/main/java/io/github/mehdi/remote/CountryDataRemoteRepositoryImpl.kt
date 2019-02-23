package io.github.mehdi.remote

import io.github.mehdi.remote.mapper.CountryMapper
import io.github.mehdi.remote.restful.APIs
import io.github.mehdi.data.model.DataCountryModel
import io.github.mehdi.data.repositories.country.CountryDataRemote
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class CountryDataRemoteRepositoryImpl
@Inject constructor(
    private val apIs: APIs,
    private val mapper: CountryMapper
)
    : CountryDataRemote
{
    override suspend fun getCountryList(): Deferred<List<DataCountryModel>> {
        return GlobalScope.async { mapper.mapFromRemote(apIs.getCountryList().await()) }
    }

}