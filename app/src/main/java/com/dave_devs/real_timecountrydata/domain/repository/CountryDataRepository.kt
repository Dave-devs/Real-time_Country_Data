package com.dave_devs.real_timecountrydata.domain.repository

import com.dave_devs.real_timecountrydata.data.remote.CountryDataResponse

interface CountryDataRepository {

    suspend fun searchCountryData(name: String): List<CountryDataResponse>

}