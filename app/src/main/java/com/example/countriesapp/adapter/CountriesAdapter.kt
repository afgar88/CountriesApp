package com.example.countriesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesapp.R
import com.example.countriesapp.model.Countries
import com.example.countriesapp.model.CountriesItem

class CountriesAdapter(
    private var countriesList: MutableList<CountriesItem> = mutableListOf()
) : RecyclerView.Adapter<CountriesViewAdapter>() {

    fun update(countriesL: List<CountriesItem>) {
        countriesList.clear()
        countriesList.addAll(countriesL)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewAdapter {
        val countriesItem =
            LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountriesViewAdapter(countriesItem)
    }

    override fun onBindViewHolder(holder: CountriesViewAdapter, position: Int) {
        val my_country = countriesList[position]
        holder.bind(my_country)
    }

    override fun getItemCount(): Int = countriesList.size


}


class CountriesViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.id_name_country)
    private val region: TextView = itemView.findViewById(R.id.id_region_country)
    private val code: TextView = itemView.findViewById(R.id.id_code_country)
    private val capital: TextView = itemView.findViewById(R.id.id_capital_country)

    fun bind(countryInfo: CountriesItem) {
        name.text = countryInfo.name
        region.text = countryInfo.region
        code.text = countryInfo.code
        capital.text = countryInfo.capital
    }
}
