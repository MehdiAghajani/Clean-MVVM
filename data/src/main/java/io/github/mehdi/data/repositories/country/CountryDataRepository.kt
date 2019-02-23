package io.github.mehdi.data.repositories.country

import io.github.mehdi.data.mapper.CountryMapper
import io.github.mehdi.domain.model.DomainCountryModel
import io.github.mehdi.domain.repository.CountryRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class CountryDataRepository
@Inject constructor(
    private val factory: CountryDataStoreFactory,
    private val mapper: CountryMapper
)
    : CountryRepository
{
    override suspend fun getCountryList(): Deferred<List<DomainCountryModel>> {
        return GlobalScope.async { factory.getCountryList().await().map { mapper.mapFromEntity(it) } }
    }
}