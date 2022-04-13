package com.example.pokedexproject.repository

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedexproject.client.RetrofitInstance
import com.example.pokedexproject.data.Pokemon
import com.google.gson.JsonObject

class Repository {
    private val repositoryLiveData: MutableLiveData<List<Pokemon>> = MutableLiveData()

    suspend fun getPokemonById(id: Int): JsonObject{
        return RetrofitInstance.api.getPokemonById(id)
    }

    suspend fun getPokemonByName(name: String): JsonObject{
        return RetrofitInstance.api.getPokemonByName(name)
    }

    fun getPokemonForId(id: Int): Pokemon? {
        repositoryLiveData.value?.let { pokemons ->
            return pokemons.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getPokemonList(): MutableLiveData<List<Pokemon>> {
        return repositoryLiveData
    }

    fun addPokemon(pokemon: Pokemon) {
        val currentList = repositoryLiveData.value
        if (currentList == null) {
            repositoryLiveData.setValue(listOf(pokemon))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, pokemon)
            repositoryLiveData.postValue(updatedList)
        }
    }

    companion object {
        private var INSTANCE: Repository? = null

        fun getRepository(): Repository {
            return synchronized(Repository::class) {
                val newInstance = INSTANCE ?: Repository()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

}