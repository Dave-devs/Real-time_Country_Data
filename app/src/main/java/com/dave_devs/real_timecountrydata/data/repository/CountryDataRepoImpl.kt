package com.dave_devs.real_timecountrydata.data.repository

import com.dave_devs.real_timecountrydata.data.remote.CountryApi
import com.dave_devs.real_timecountrydata.data.remote.CountryDataResponse
import com.dave_devs.real_timecountrydata.domain.repository.CountryDataRepository
import javax.inject.Inject

class CountryDataRepoImpl @Inject constructor(
    private val api: CountryApi
): CountryDataRepository {
    override suspend fun searchCountryData(name: String): List<CountryDataResponse> {
       return api.searchCountryData(name)
    }
}