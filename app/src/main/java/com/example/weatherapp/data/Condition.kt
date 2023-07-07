package com.example.weatherapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
): Parcelable