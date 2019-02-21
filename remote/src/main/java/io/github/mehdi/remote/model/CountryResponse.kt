package io.github.mehdi.remote.model

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("RestResponse") val restResponse: CountryRestResponse
)

data class CountryRestResponse(
    @SerializedName("messages") val messages: List<String>,
    @SerializedName("result") val result: List<CountryModel>
)

data class CountryModel(
    @SerializedName("name") val name: String,
    @SerializedName("alpha2_code") val alpha2: String,
    @SerializedName("alpha3_code") val alpha3: String
    )