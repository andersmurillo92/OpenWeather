package com.openweather.views.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.openweather.R
import com.openweather.data.model.ThreeHoursDataModel
import com.openweather.databinding.ItemDayForecastedBinding
import com.openweather.views.interfaces.ItemActionListener
import java.text.SimpleDateFormat

class DayForecastedAdapter(private val itemActionListener: ItemActionListener) : RecyclerView.Adapter<DayForecastedAdapter.ViewHolder>() {

    private val list = mutableListOf<List<ThreeHoursDataModel>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_day_forecasted, parent, false
            ), parent, itemActionListener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int =
        list.size

    fun onUpdateData(items: List<List<ThreeHoursDataModel>>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(
        view: View,
        private val parent: ViewGroup,
        private val itemActionListener: ItemActionListener
    ) : RecyclerView.ViewHolder(view) {

        private val binding = ItemDayForecastedBinding.bind(view)

        fun bind(item: List<ThreeHoursDataModel>) {
            with(binding) {
                dateTitle.text = item[0].dt_txt?.toDate().toString().capitalize()

                val adapter = ThreeHoursWeatherAdapter(itemActionListener)
                weatherRecycler.layoutManager = LinearLayoutManager(parent.context, RecyclerView.HORIZONTAL, false)
                weatherRecycler.adapter = adapter
                adapter.onUpdateData(item)
            }
        }

        private fun String.toDate(): String {
            val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val formatter = SimpleDateFormat("EEEE, dd MMMM")

            return formatter.format(parser.parse(this))
        }
    }
}