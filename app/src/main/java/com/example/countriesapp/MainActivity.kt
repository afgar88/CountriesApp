package com.example.countriesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countriesapp.adapter.CountriesAdapter
import com.example.countriesapp.databinding.ActivityMainBinding
import com.example.countriesapp.model.Countries
import com.example.countriesapp.model.CountriesItem
import com.example.countriesapp.utils.CountriesState
import com.example.countriesapp.viewmodel.CountriesViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: CountriesViewModel = CountriesViewModel()

    private val countriesAdapter by lazy {
        CountriesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.idRecycler.apply {

            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = countriesAdapter
        }

        viewModel.getAllCountries()
        viewModel.countries.observe(this) {
            when (it) {
                is CountriesState.LOADING -> {
                    Toast.makeText(this, "loading...", Toast.LENGTH_LONG).show()
                }
                is CountriesState.SUCCESS<*> -> {
                    var countries = it.countries as Countries
                    countriesAdapter.update(countries)
                }
                is CountriesState.ERROR -> {
                    Toast.makeText(
                        this,
                        it.error.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}