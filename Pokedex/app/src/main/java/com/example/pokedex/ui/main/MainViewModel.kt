package com.example.pokedex.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val pokemonLiveData = MutableLiveData<List<Pokemon>>()

    fun getFilmes(){
        repository.getPokemons { pokemons ->
            pokemonLiveData.value = pokemons
        }
    }

    class MainViewModelFactory(
        private val repository: MainRepository
    ): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}