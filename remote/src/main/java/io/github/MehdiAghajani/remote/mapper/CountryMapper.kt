package io.github.MehdiAghajani.remote.mapper

import io.github.MehdiAghajani.remote.model.CountryResponse
import io.github.MehdiAghajani.data.model.DataCountryModel
import javax.inject.Inject

class CountryMapper @Inject constructor(): EntityMapper<CountryResponse, List<DataCountryModel>>
{
    override fun mapFromRemote(type: CountryResponse): List<DataCountryModel> {
        val countryList: MutableList<DataCountryModel> = mutableListOf()
        type.restResponse.result.forEach {
            countryList.add(
                DataCountryModel(it.name, it.alpha2, it.alpha3)
            )
        }
        return countryList.toList()
    }
}