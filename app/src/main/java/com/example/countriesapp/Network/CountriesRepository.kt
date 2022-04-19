package com.example.countriesapp.Network

import com.example.countriesapp.model.Countries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

interface CountriesRepository {
    suspend fun getAllCountries(): Response<Countries>

}

class CountriesRepositoryImp(private val countriesService: CountriesService) : CountriesRepository {
    override suspend fun getAllCountries(): Response<Countries> =
        countriesService.getAllCountries()
}