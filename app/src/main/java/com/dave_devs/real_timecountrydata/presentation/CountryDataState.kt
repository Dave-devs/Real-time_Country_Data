package com.dave_devs.real_timecountrydata.presentation

import com.dave_devs.real_timecountrydata.data.remote.CountryDataResponse

data class CountryDataState(
    val countryData: List<CountryDataResponse> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = " "
)
