package com.example.pokedexproject.client
import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonClient {
    @GET("api/v2/pokemon-species/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): JsonObject

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): JsonObject
}