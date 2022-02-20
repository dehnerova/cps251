package com.adehnerova.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adehnerova.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        //collecting text box input as a string
        if (binding.billAmount.text.isNotEmpty()) {

            binding.txtView.text = getString(R.string.mainText)

            val stringInTextInput = binding.billAmount.text.toString()
            //converting text to a double variable
            val inDollarAmount = stringInTextInput.toDouble()

            val tipTen = (0.10 * inDollarAmount)
            val tipFifteen = (0.15 * inDollarAmount)
            val tipTwenty = (0.20 * inDollarAmount)

            //formatting double values to display as dollar amounts
            val formattedTen = NumberFormat.getCurrencyInstance().format(tipTen)
            val formattedFifteen = NumberFormat.getCurrencyInstance().format(tipFifteen)
            val formattedTwenty = NumberFormat.getCurrencyInstance().format(tipTwenty)

            //binding text
            binding.txtView.text = getString(R.string.txtView, formattedTen, formattedFifteen, formattedTwenty)

        } else {
            //if no input, display reminder
            binding.txtView.text = getString(R.string.errorCall)
        }
    }

}