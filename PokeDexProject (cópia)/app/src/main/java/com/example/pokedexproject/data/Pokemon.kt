package com.example.pokedexproject.data

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val name: String,
    @DrawableRes
    val image: Int?,
    val weight: Int,
    val height: Int,
    val hp: Int,
    val attack: Int,
    val defense: Int
)