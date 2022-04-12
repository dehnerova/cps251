package edu.adehnerova.recyclewithintent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.adehnerova.recyclewithintent.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    var data = Data.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var extras = intent.extras ?: return
        var arrTitle = extras.getInt("title")
        var arrDetail = extras.getInt("details")
        var arrImage = extras.getInt("image")

        Log.d("SCNDACTIVITY", "in second, $arrDetail")

        binding.titleText.text = data.titles[arrTitle]
        binding.detailText.text = data.details[arrDetail]
        binding.image.setImageResource(data.images[arrImage])
    }
}