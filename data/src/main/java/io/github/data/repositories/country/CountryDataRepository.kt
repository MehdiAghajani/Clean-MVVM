package io.github.data.repositories.country

import io.github.domain.model.DomainCountryModel
import io.github.domain.repository.CountryRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class CountryDataRepository
@Inject constructor(private val factory : CountryDataStoreFactory)
    : CountryRepository
{
    override fun getCountryList(): Deferred<List<DomainCountryModel>> {
        return factory.getCountryList()
    }
}