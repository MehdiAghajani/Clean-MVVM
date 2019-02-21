package io.github.mehdi.remote.restful

import io.github.mehdi.remote.model.CountryResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface APIs {

    @GET("/country/get/all")
    fun getCountryList(): Deferred<CountryResponse>
}