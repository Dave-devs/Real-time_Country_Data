package com.dave_devs.real_timecountrydata.presentation.screen

sealed class UiEvent {
    data class ShowSnackBar(val message: String): UiEvent()
}