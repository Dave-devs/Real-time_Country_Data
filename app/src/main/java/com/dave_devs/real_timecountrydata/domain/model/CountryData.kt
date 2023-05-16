package com.dave_devs.real_timecountrydata.domain.model

import com.dave_devs.real_timecountrydata.data.local.CountryDataEntity

data class CountryData(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Int,
    val borders: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val currencies: List<Currency>,
    val demonym: String,
    val flag: String,
    val gini: Double,
    val languages: List<Language>,
    val latlng: List<Int>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val regionalBlocs: List<RegionalBloc>,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
    val translations: Translations
) {
    fun toCountryDataEntity(): CountryDataEntity {
        return CountryDataEntity(
            alpha2Code = alpha2Code,
            alpha3Code = alpha3Code,
            altSpellings = altSpellings,
            area = area,
            borders = borders,
            callingCodes = callingCodes,
            capital = capital,
            cioc = cioc,
            currencies = currencies,
            demonym = demonym,
            flag = flag,
            gini = gini,
            languages = languages,
            latlng = latlng,
            name = name,
            nativeName = nativeName,
            numericCode = numericCode,
            population = population,
            region = region,
            regionalBlocs = regionalBlocs,
            subregion = subregion,
            timezones = timezones,
            topLevelDomain = topLevelDomain,
            translations = translations
        )
    }
}