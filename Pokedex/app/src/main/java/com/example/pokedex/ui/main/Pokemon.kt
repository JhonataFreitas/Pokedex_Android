package com.example.pokedex.ui.main

import android.media.Image

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val image: Image?,
    val hp: Int,
    val attack: Int,
    val defense: Int
)