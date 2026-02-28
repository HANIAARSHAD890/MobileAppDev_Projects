package com.example.bmi_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class BmiStatusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiStatusBinding
    private lateinit var viewModel: BmiStatusViewModel
    private var computedBmiValue: Double = 0.0
    private lateinit var viewModelFactory: BmiStatusActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bmi_status)
        computedBmiValue = intent.getDoubleExtra("BMI_Value", 0.0)
        binding.bmiValue.text = computedBmiValue.toString()
        binding.bmiValuesTable.layoutManager = LinearLayoutManager(this)
        viewModelFactory = BmiStatusActivityViewModelFactory(computedBmiValue)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(BmiStatusViewModel::class.java)
        viewModel.bmiValuesListLiveData.observe(this, Observer { bmiValuesList ->
            binding.bmiValuesTable.adapter =
                BmiValuesListAdapter(applicationContext, bmiValuesList)
            (binding.bmiValuesTable.adapter as BmiValuesListAdapter).notifyDataSetChanged()
        })
    }
}