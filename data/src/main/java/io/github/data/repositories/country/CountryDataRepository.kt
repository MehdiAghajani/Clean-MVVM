package io.github.data.repositories.country

import io.github.data.mapper.CountryMapper
import io.github.domain.model.DomainCountryModel
import io.github.domain.repository.CountryRepository
import javax.inject.Inject

class CountryDataRepository
@Inject constructor(
    private val factory: CountryDataStoreFactory,
    private val mapper: CountryMapper)
    : CountryRepository
{
    override suspend fun getCountryList(): List<DomainCountryModel> {
        return factory.getCountryList().map { mapper.mapFromEntity(it) }
    }
}