package io.github.MehdiAghajani.data.mapper

import io.github.MehdiAghajani.data.model.DataCountryModel
import io.github.MehdiAghajani.domain.model.DomainCountryModel
import javax.inject.Inject

class CountryMapper @Inject constructor():
    Mapper<DataCountryModel, DomainCountryModel> {

    override fun mapToEntity(type: DomainCountryModel): DataCountryModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapFromEntity(type: DataCountryModel): DomainCountryModel {
        return DomainCountryModel(type.name, type.alpha2_code, type.alpha3_code)
    }
}