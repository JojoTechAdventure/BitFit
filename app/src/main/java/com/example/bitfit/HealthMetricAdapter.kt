package com.example.bitfit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit.databinding.ItemHealthMetricBinding

class HealthMetricAdapter(private var healthMetrics: List<HealthMetric> = emptyList()) : RecyclerView.Adapter<HealthMetricAdapter.HealthMetricViewHolder>() {

    class HealthMetricViewHolder(val binding: ItemHealthMetricBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthMetricViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHealthMetricBinding.inflate(layoutInflater, parent, false)
        return HealthMetricViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HealthMetricViewHolder, position: Int) {
        val currentHealthMetric = healthMetrics[position]
        holder.binding.apply {
            foodNameTextView.text = currentHealthMetric.foodName
            caloriesTextView.text = currentHealthMetric.calories.toString()
        }
    }

    override fun getItemCount(): Int = healthMetrics.size

    fun updateData(newHealthMetrics: List<HealthMetric>) {
        healthMetrics = newHealthMetrics
        notifyDataSetChanged()
    }
}
