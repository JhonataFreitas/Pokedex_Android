package com.example.pokedexproject.pokemonDetail
import androidx.lifecycle.ViewModel
import com.example.pokedexproject.repository.*

class PokemonDetailViewModel(private val repository: Repository) : ViewModel() {
    fun getPokemonForId(id: Int) : Pokemon? {
        return repository.getPokemonForId(id)
    }
}