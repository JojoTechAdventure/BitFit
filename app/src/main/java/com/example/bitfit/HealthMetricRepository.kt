package com.example.bitfit

import kotlinx.coroutines.flow.Flow

class HealthMetricRepository(private val healthMetricDao: HealthMetricDao) {
    val allHealthMetrics: Flow<List<HealthMetric>> = healthMetricDao.getAllFoodEntries()

    suspend fun insert(healthMetric: HealthMetric) {
        healthMetricDao.insert(healthMetric)
    }
}
