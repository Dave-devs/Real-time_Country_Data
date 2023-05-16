package com.dave_devs.real_timecountrydata.domain.repository

import com.dave_devs.real_timecountrydata.domain.model.CountryData
import com.dave_devs.real_timecountrydata.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface CountryDataRepository {
    suspend fun searchCountryData(name: String): Flow<Resource<List<CountryData>>>

}