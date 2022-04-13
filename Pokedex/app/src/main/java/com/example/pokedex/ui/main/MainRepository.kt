package com.example.pokedex.ui.main;

class MainRepository {
    fun getPokemons(callback: (pokemons: List<Pokemon>) -> Unit) {
        Thread(Runnable {
            callback.invoke(
                listOf(
                    Pokemon(1,"Bulbassaur",10,10,null,10,10,10),
                    Pokemon(1,"Charmander",10,10,null,10,10,10),
                    Pokemon(1,"Squirtle",10,10,null,10,10,10)
                )
            )
        })
    }
}
