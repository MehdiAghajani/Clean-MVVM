package io.github.mehdi.domain.usecase.country

import io.github.mehdi.domain.model.DomainCountryModel
import io.github.mehdi.domain.repository.CountryRepository
import io.github.mehdi.domain.usecase.BaseUseCase
import io.github.mehdi.domain.usecase.UseCaseErrorUtil
import io.github.mehdi.domain.usecase.UseCaseThreads
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class GetCountryListUseCase
    @Inject constructor(
        errorUtil: UseCaseErrorUtil,
        threads: UseCaseThreads,
        private val countryRepository: CountryRepository
    )
    :BaseUseCase<List<DomainCountryModel>>(errorUtil, threads)
{
    override suspend fun buildUseCaseDeferred(): Deferred<List<DomainCountryModel>> {
        return countryRepository.getCountryList()
    }
}