package com.dave_devs.real_timecountrydata.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dave_devs.real_timecountrydata.domain.model.CountryData

@Composable
fun CountryDataItem(
    modifier: Modifier = Modifier,
    countryData: CountryData
) {
    Column(modifier) {
        Text(
            text = countryData.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Alpha2Code: ${countryData.alpha2Code}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Alpha3Code: ${countryData.alpha3Code}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Calling Code: ${countryData.callingCodes}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Capital: ${countryData.capital}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Alt Spelling: ${countryData.altSpellings}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Region: ${countryData.region}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Sub-region: ${countryData.subregion}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Population: ${countryData.population}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Latitude/Longitude: ${countryData.latlng}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Demonym: ${countryData.demonym}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Area: ${countryData.area}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Gini: ${countryData.gini}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Timezone: ${countryData.timezones}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Borders: ${countryData.borders.size}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Native name: ${countryData.name}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Numeric code: ${countryData.numericCode}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Currencies: ${countryData.currencies}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        countryData.languages.forEach { lang ->
            Text(
                text = lang.name,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier.height(6.dp))
            Text(
                text = lang.nativeName,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier.height(6.dp))
            Text(
                text = lang.iso639_1,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier.height(6.dp))
            Text(
                text = lang.iso639_2,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(Modifier.height(10.dp))
        //Translation
        Text(
            text = "Translations: ",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = countryData.translations.br,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.de,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.es,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.fr,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.fa,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.hr,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.it,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.pt,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.nl,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = countryData.translations.ja,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(10.dp))
        countryData.regionalBlocs.forEach { regionalBloc -> 
            Text(
                text = regionalBloc.name,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier.height(6.dp))
            Text(
                text = regionalBloc.acronym,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Cioc: ${countryData.cioc}",
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}