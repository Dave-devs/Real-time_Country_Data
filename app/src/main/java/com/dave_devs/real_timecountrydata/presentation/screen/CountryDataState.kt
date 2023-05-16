package com.dave_devs.real_timecountrydata.presentation.screen

import com.dave_devs.real_timecountrydata.domain.model.CountryData

data class CountryDataState(
    val countryDataItems: List<CountryData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = " "
)
