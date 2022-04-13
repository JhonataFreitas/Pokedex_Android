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
import com.example.pokedexproject.repository.Pokemon
import com.squareup.picasso.Picasso

class PokemonsAdapter(private val onClick: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonsAdapter.PokemonViewHolder>(PokemonDiffCallback) {

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

        fun bind(pokemon: Pokemon) {
            currentPokemon = pokemon

            pokemonTextView.text = "#" +pokemon.id+ " - " + pokemon.name
            if (pokemon.image != null) {
                Picasso.get().load(pokemon.image).into(pokemonImageView);
            } else {
                pokemonImageView.setImageResource(R.drawable.bulbassaur)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view, onClick)
    }

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