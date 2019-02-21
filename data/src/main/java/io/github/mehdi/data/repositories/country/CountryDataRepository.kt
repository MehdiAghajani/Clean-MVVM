package io.github.mehdi.data.repositories.country

import io.github.mehdi.data.mapper.CountryMapper
import io.github.mehdi.domain.model.DomainCountryModel
import io.github.mehdi.domain.repository.CountryRepository
import javax.inject.Inject

class CountryDataRepository
@Inject constructor(
    private val factory: CountryDataStoreFactory,
    private val mapper: CountryMapper
)
    : CountryRepository
{
    override suspend fun getCountryList(): List<DomainCountryModel> {
        return factory.getCountryList().map { mapper.mapFromEntity(it) }
    }
}