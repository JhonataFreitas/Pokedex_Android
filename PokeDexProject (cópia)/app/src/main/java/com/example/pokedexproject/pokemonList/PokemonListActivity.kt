package com.example.pokedexproject.pokemonList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexproject.pokemonDetail.PokemonDetailActivity
import com.example.pokedexproject.R
import com.example.pokedexproject.data.Pokemon
import com.example.pokedexproject.repository.Repository

const val POKEMON_ID = "pokemon id"

class PokemonsListActivity : AppCompatActivity() {
    private lateinit var viewModel: PokemonsListViewModel
    private lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = Repository()
        val viewModelFactory = PokemonsListViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(PokemonsListViewModel::class.java)
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
        println("\t\t\t\t\t\t\t\t" + pokemon)
        val intent = Intent(this, PokemonDetailActivity()::class.java)
        intent.putExtra(POKEMON_ID, pokemon.id)
        startActivity(intent)
    }
}