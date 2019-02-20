package io.github.MehdiAghajani.data.repositories.country

import io.github.MehdiAghajani.data.mapper.CountryMapper
import io.github.MehdiAghajani.domain.model.DomainCountryModel
import io.github.MehdiAghajani.domain.repository.CountryRepository
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