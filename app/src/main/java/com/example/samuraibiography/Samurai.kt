package com.example.samuraibiography
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Samurai(
    val name: String,
    val description : String,
    val photo: Int
) : Parcelable
