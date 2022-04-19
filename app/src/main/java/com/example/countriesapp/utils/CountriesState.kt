package com.example.countriesapp.utils

sealed class CountriesState {
    object LOADING:CountriesState()
    class SUCCESS<T>(val countries:T):CountriesState()
    class ERROR(val error:Throwable):CountriesState()
}
