package com.dave_devs.real_timecountrydata.domain.model

data class Language(
    val iso639_1: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
)