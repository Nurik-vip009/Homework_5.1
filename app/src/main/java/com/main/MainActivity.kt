package com.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_51.databinding.ActivityMainBinding
import com.view.CounterView


class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var count = 0
    var presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        binding.incrementBtn.setOnClickListener {
            presenter.increment()
        }
    }

    override fun updateActualCounter(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.counterTv.setTextColor(color)
    }


}
