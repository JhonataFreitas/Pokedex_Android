package com.example.pokedexproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PokemonData{
/*    private val initialPokemonList = pokemonList()
    private val pokemonsLiveData = MutableLiveData(initialPokemonList)

    fun getPokemonForId(id: Int): Pokemon? {
        pokemonsLiveData.value?.let { pokemons ->
            return pokemons.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getPokemonList(): LiveData<List<Pokemon>> {
        return pokemonsLiveData
    }

    companion object {
        private var INSTANCE: PokemonData? = null

        fun getDataSource(): PokemonData {
            return synchronized(PokemonData::class) {
                val newInstance = INSTANCE ?: PokemonData()
                INSTANCE = newInstance
                newInstance
            }
        }
    }*/
}