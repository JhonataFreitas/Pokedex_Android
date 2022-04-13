package com.example.pokedexproject.pokemonList
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexproject.R
import com.example.pokedexproject.constants.POKEMON_ID
import com.example.pokedexproject.pokemonDetail.PokemonDetailActivity
import com.example.pokedexproject.repository.Pokemon
import com.example.pokedexproject.repository.Repository
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PokemonsListActivity : AppCompatActivity() {
    private val viewModel: PokemonsListViewModel by viewModel {
        parametersOf(Repository.getRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val headerAdapter = HeaderAdapter()
        val pokemonsAdapter = PokemonsAdapter { pokemon -> adapterOnClick(pokemon) }
        val concatAdapter = ConcatAdapter(headerAdapter, pokemonsAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = concatAdapter
        viewModel.getPokemonList()
        viewModel.responsePokemon.observe(this, {
            it?.let {
                    pokemonsAdapter.submitList(it as MutableList<Pokemon>)
                    headerAdapter.updatePokemonCount(it.size)
            }
        })
    }

    private fun adapterOnClick(pokemon: Pokemon) {
        val intent = Intent(this, PokemonDetailActivity()::class.java)
        intent.putExtra(POKEMON_ID, pokemon.id)
        startActivity(intent)
    }
}