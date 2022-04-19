package com.example.countriesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.countriesapp.Network.CountriesService
import com.example.countriesapp.databinding.ActivityMainBinding
import com.example.countriesapp.model.Countries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        CountriesService.retrofitService.getAllCountries().enqueue(object : Callback<Countries>{
//            override fun onResponse(call: Call<Countries>, response: Response<Countries>) {
//
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        Log.d("Paises",it[0].name)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<Countries>, t: Throwable) {
//                Log.d("Error","Error")
//            }
//        })
    }
}