package com.swancodes.foodish.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Food(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val price: String,
    @StringRes val details: Int,
)