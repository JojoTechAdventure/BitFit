package com.example.bitfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var healthMetricAdapter: HealthMetricAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        healthMetricAdapter = HealthMetricAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = healthMetricAdapter
        }

        // Make sure the button ID matches the one in your layout file
        val addFoodButton: Button = findViewById(R.id.addFoodButton)
        addFoodButton.setOnClickListener {
            // The Intent is correct; make sure NewEntryActivity is registered in the AndroidManifest.xml
            startActivity(Intent(this, NewEntryActivity::class.java))
        }

        viewModel.allHealthMetrics.observe(this) { healthMetrics ->
            healthMetricAdapter.updateData(healthMetrics)
        }
    }
}
