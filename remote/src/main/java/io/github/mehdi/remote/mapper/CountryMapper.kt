package io.github.mehdi.remote.mapper

import io.github.mehdi.remote.model.CountryResponse
import io.github.mehdi.data.model.DataCountryModel
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