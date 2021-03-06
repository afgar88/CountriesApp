package com.example.countriesapp.Network

import com.example.countriesapp.model.Countries
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountriesService {

    @GET(COUNTRIES)
    suspend fun getAllCountries(): Response<Countries>

    companion object {
        private const val BASE_URL =
            "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"
        const val COUNTRIES = "countries.json"

        val retrofitService =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountriesService::class.java)
    }
}

