package com.example.filmescoroutines.ui.main

import javax.security.auth.callback.Callback

class MainRepository {
    fun getFilmes(callback: (filmes: List<Filme>) -> Unit){
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1,"As Branquelas"),
                    Filme(2,"Debi e Loide")
                )
            )
        })
    }
}