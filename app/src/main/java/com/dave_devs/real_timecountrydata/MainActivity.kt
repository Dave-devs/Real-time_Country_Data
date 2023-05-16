package com.dave_devs.real_timecountrydata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dave_devs.real_timecountrydata.presentation.screen.CountryDataScreen
import com.dave_devs.real_timecountrydata.presentation.ui.theme.RealtimeCountryDataTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealtimeCountryDataTheme {
                CountryDataScreen()
            }
        }
    }
}