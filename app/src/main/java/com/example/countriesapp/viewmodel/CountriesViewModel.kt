package com.example.countriesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.Network.CountriesRepository
import com.example.countriesapp.Network.CountriesRepositoryImp
import com.example.countriesapp.model.CountriesItem
import com.example.countriesapp.utils.CountriesState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val country:CountriesRepositoryImp,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _allCountries: MutableLiveData<CountriesState> =
        MutableLiveData(CountriesState.LOADING)
    val countries: LiveData<CountriesState> get() = _allCountries

    fun getAllCountries() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = country.getAllCountries()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _allCountries.postValue(CountriesState.SUCCESS(it))
                    } ?: throw Exception("Response is null")

                } else {
                    throw Exception("No successful response")
                }
            } catch (e: Exception) {
                _allCountries.postValue(CountriesState.ERROR(e))
            }
        }
    }
}