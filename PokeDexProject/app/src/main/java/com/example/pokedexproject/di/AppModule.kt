package com.example.pokedexproject.di
import com.example.pokedexproject.pokemonDetail.PokemonDetailViewModel
import com.example.pokedexproject.pokemonList.PokemonsListViewModel
import com.example.pokedexproject.repository.Repository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        (repository: Repository) -> PokemonsListViewModel(repository)
    }

    viewModel {
        (repository: Repository) -> PokemonDetailViewModel(repository)
    }
}