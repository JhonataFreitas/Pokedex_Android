package com.example.pokedexproject.pokemonDetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexproject.R
import com.example.pokedexproject.constants.POKEMON_ID
import com.example.pokedexproject.repository.Repository
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PokemonDetailActivity() : AppCompatActivity() {
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModel {
        parametersOf(Repository.getRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_detail_activity)

        var currentPokemonId: Int? = null

        val pokemonName: TextView = findViewById(R.id.pokemon_detail_name)
        val pokemonImage: ImageView = findViewById(R.id.pokemon_detail_image)
        val pokemonWeight: TextView = findViewById(R.id.pokemon_detail_weight)
        val pokemonHeight: TextView = findViewById(R.id.pokemon_detail_height)
        val pokemonStats: TextView = findViewById(R.id.pokemon_detail_stats)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentPokemonId = bundle.getInt(POKEMON_ID)
        }

        currentPokemonId?.let {
            val currentPokemon = pokemonDetailViewModel.getPokemonForId(it)
            println(currentPokemon)
            pokemonName.text = currentPokemon?.name
            if (currentPokemon?.image == null) {
                pokemonImage.setImageResource(R.drawable.bulbassaur)
            } else {
                Picasso.get().load(currentPokemon?.image).into(pokemonImage);
            }
            pokemonWeight.text = "WEIGHT: " +currentPokemon?.weight.toString()
            pokemonHeight.text = "HEIGHT: " +currentPokemon?.height.toString()
            pokemonStats.text = "HP: " + currentPokemon?.hp.toString()+
                    "\t\t\t ATTACK:" + currentPokemon?.attack + "\t\t\t DEFENSE: "+ currentPokemon?.defense

        }

    }
}