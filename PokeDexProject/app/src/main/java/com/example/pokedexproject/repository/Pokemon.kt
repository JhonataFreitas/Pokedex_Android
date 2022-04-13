package com.example.pokedexproject.repository

data class Pokemon(
    val id: Int,
    val name: String,
    val image: String?,
    val weight: Int,
    val height: Int,
    val hp: Int,
    val attack: Int,
    val defense: Int
)