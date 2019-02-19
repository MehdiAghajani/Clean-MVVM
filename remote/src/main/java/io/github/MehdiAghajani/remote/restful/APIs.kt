package io.github.MehdiAghajani.remote.restful

import io.github.MehdiAghajani.remote.model.CountryResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface APIs {

    //http://services.groupkt.com/country/get/all
    @GET("/country/get/all")
    fun getCountryList(): Deferred<CountryResponse>
}