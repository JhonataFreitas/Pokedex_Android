package com.example.pokedexproject.pokemonList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexproject.R
import com.example.pokedexproject.data.Pokemon

class PokemonsAdapter(private val onClick: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonsAdapter.PokemonViewHolder>(PokemonDiffCallback) {

    /* ViewHolder for Pokemon, takes in the inflated view and the onClick behavior. */
    class PokemonViewHolder(itemView: View, val onClick: (Pokemon) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val pokemonTextView: TextView = itemView.findViewById(R.id.pokemon_text)
        private val pokemonImageView: ImageView = itemView.findViewById(R.id.pokemon_image)
        private var currentPokemon: Pokemon? = null

        init {
            itemView.setOnClickListener {
                currentPokemon?.let {
                    onClick(it)
                }
            }
        }

        /* Bind Pokemon name and image. */
        fun bind(pokemon: Pokemon) {
            currentPokemon = pokemon

            pokemonTextView.text = "#" +pokemon.id+ " - " + pokemon.name
            if (pokemon.image != null) {
                pokemonImageView.setImageResource(pokemon.image)
            } else {
                pokemonImageView.setImageResource(R.drawable.bulbassaur)
            }
        }
    }

    /* Creates and inflates view and return PokemonViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view, onClick)
    }

    /* Gets current pokemon and uses it to bind view. */
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)

    }
}

object PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }
}