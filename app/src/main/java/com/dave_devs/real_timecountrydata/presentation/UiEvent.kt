package com.dave_devs.real_timecountrydata.presentation

sealed class UiEvent {
    data class ShowSnackBar(val message: String): UiEvent()
}