package com.example.pokedexproject.pokemonList

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedexproject.R
import com.example.pokedexproject.data.Pokemon
import com.example.pokedexproject.data.PokemonData
import com.example.pokedexproject.repository.Repository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

const val FIRST_POKEMON = 1
const val LAST_POKEMON = 151


class PokemonsListViewModel(private val repository: Repository) : ViewModel() {

    val responsePokemon = repository.getPokemonList()

    fun getPokemonList(){
        viewModelScope.launch {
            for (i in 151 downTo 1){
                val pokemonName = repository.getPokemonById(i).get("name").asString
                val pokemon = createPokemon(repository.getPokemonByName(pokemonName))
                repository.addPokemon(pokemon)
            }
        }
    }

    fun createPokemon(obj: JsonObject): Pokemon {
        var stats = obj.get("stats").asJsonArray
        return Pokemon(obj.get("id").asInt,
            obj.get("name").asString,
            R.drawable.bulbassaur,
            obj.get("weight").asInt,
            obj.get("height").asInt,
            stats[0].asJsonObject.get("base_stat").asInt,
            stats[1].asJsonObject.get("base_stat").asInt,
            stats[2].asJsonObject.get("base_stat").asInt
        )
    }
}

class PokemonsListViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonsListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PokemonsListViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}