package com.openweather.views.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openweather.R
import com.openweather.data.model.ThreeHoursDataModel
import com.openweather.data.model.baseURLImage
import com.openweather.databinding.ItemThreeHoursWeatherBinding
import com.openweather.views.interfaces.ItemActionListener
import com.squareup.picasso.Picasso

class ThreeHoursWeatherAdapter(private val itemActionListener: ItemActionListener) : RecyclerView.Adapter<ThreeHoursWeatherAdapter.ViewHolder>() {

    private val list = arrayListOf<ThreeHoursDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_three_hours_weather, parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            itemActionListener.onClickItem(movie, position)
        }
    }

    override fun getItemCount(): Int = list.size

    fun onUpdateData(items: List<ThreeHoursDataModel>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun isEmpty(): Boolean = list.isEmpty()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemThreeHoursWeatherBinding.bind(view)

        fun bind(item: ThreeHoursDataModel) {
            binding.weatherTemp.text = "${item.main?.temp.toString()} °F"
            binding.weatherHour.text = item.dt.toString()
            Picasso.get().load("$baseURLImage${item.weather[0].icon}.png").into(binding.weatherIcon)
        }
    }
}