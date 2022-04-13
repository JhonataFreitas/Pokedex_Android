package com.example.pokedexproject.pokemonList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexproject.constants.*
import com.example.pokedexproject.repository.*
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class PokemonsListViewModel(private val repository: Repository) : ViewModel() {
    val responsePokemon = repository.getPokemonList()

    fun getPokemonList(){
        viewModelScope.launch {
            for (i in LAST_POKEMON downTo FIRST_POKEMON){
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
            BASE_IMAGE_URL + obj.get("id").asInt + ".png",
            obj.get("weight").asInt,
            obj.get("height").asInt,
            stats[0].asJsonObject.get("base_stat").asInt,
            stats[1].asJsonObject.get("base_stat").asInt,
            stats[2].asJsonObject.get("base_stat").asInt
        )
    }
}