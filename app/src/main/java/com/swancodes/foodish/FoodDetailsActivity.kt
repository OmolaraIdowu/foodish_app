package com.swancodes.foodish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swancodes.foodish.databinding.ActivityFoodDetailsBinding

class FoodDetailsActivity : AppCompatActivity() {

    companion object {
        const val nameKey: String = "name_key"
        const val priceKey: String = "price_key"
        const val imageKey: String = "image_key"
        const val detailsKey: String = "details_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFoodDetails(binding)
    }

    private fun setupFoodDetails(binding: ActivityFoodDetailsBinding) {
        val name = intent.getStringExtra(nameKey)
        val price = intent.getStringExtra(priceKey)
        val imageRes = intent.getIntExtra(imageKey, R.drawable.food_image1)
        val detailsRes = intent.getIntExtra(detailsKey, R.string.roasted_chicken)

        binding.apply {
            foodName.text = name
            foodPrice.text = price
            foodImage.setImageResource(imageRes)
            foodDetails.text = getString(detailsRes)

        }
    }
}/**/