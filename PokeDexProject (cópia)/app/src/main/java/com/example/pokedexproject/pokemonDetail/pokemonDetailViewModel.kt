package com.example.pokedexproject.pokemonDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexproject.data.Pokemon
import com.example.pokedexproject.data.PokemonData
import com.example.pokedexproject.repository.Repository

class PokemonDetailViewModel(private val repository: Repository) : ViewModel() {
    fun getPokemonForId(id: Int) : Pokemon? {
        return repository.getPokemonForId(id)
    }
}

class PokemonDetailViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PokemonDetailViewModel(
                repository = Repository.getRepository()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}