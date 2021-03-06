package com.example.pokedexproject.client
import com.example.pokedexproject.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    val api: PokemonClient by lazy{
        retrofit.create(PokemonClient::class.java)
    }
}