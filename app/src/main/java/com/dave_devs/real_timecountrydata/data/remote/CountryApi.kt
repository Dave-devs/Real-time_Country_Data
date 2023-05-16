package com.dave_devs.real_timecountrydata.data.remote

import com.dave_devs.real_timecountrydata.core.Constants.ACCESS_KEY
import com.dave_devs.real_timecountrydata.domain.model.CountryData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryApi {

    @GET("/v2/{name}")
    suspend fun searchCountryData(
        @Path("name") name: String,
        @Query("access_key") access_key: String = ACCESS_KEY,
        @Query("fullText") fullText: Boolean = true
    ): List<CountryData>
}