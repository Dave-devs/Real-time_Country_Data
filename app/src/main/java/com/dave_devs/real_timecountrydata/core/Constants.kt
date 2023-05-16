package com.dave_devs.real_timecountrydata.core

import com.dave_devs.real_timecountrydata.BuildConfig

object Constants {
    const val BASE_URL = "https://api.countrylayer.com"
    const val ACCESS_KEY = BuildConfig.API_ACCESS_KEY
    const val DELAY_MILLIS = 500L
    const val COUNTRY_DATA_ENTITY = "country_data_entity"
    const val COUNTRY_DATABASE = "Country_Database"
}