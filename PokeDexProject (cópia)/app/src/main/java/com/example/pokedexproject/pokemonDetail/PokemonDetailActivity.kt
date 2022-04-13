package com.example.pokedexproject.pokemonDetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexproject.R
import com.example.pokedexproject.pokemonList.POKEMON_ID
import com.example.pokedexproject.repository.Repository

class PokemonDetailActivity() : AppCompatActivity() {

    private val PokemonDetailViewModel by viewModels<PokemonDetailViewModel> {
        PokemonDetailViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_detail_activity)

        var currentPokemonId: Int? = null

        val PokemonName: TextView = findViewById(R.id.pokemon_detail_name)
        val PokemonImage: ImageView = findViewById(R.id.pokemon_detail_image)
        val PokemonWeight: TextView = findViewById(R.id.pokemon_detail_weight)
        val PokemonHeight: TextView = findViewById(R.id.pokemon_detail_height)
        val PokemonStats: TextView = findViewById(R.id.pokemon_detail_stats)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentPokemonId = bundle.getInt(POKEMON_ID)
        }

        currentPokemonId?.let {
            val currentPokemon = PokemonDetailViewModel.getPokemonForId(it)
            println(currentPokemon)
            PokemonName.text = currentPokemon?.name
            if (currentPokemon?.image == null) {
                PokemonImage.setImageResource(R.drawable.bulbassaur)
            } else {
                PokemonImage.setImageResource(currentPokemon.image)
            }
            PokemonWeight.text = "WEIGHT: " +currentPokemon?.weight.toString()
            PokemonHeight.text = "HEIGHT: " +currentPokemon?.height.toString()
            PokemonStats.text = "HP: " + currentPokemon?.hp.toString()+
                    "\t\t\t ATTACK:" + currentPokemon?.attack + "\t\t\t DEFENSE: "+ currentPokemon?.defense

        }

    }
}