package com.example.pokedexproject.pokemonList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexproject.R

class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var pokemonCount: Int = 0
    
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val pokemonNumberTextView: TextView = itemView.findViewById(R.id.pokemon_number_text)

        fun bind(pokemonCount: Int) {
            pokemonNumberTextView.text = pokemonCount.toString()
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_item, parent, false)
        return HeaderViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(pokemonCount)
    }
    
    override fun getItemCount(): Int {
        return 1
    }
    
    fun updatePokemonCount(updatedPokemonCount: Int) {
        pokemonCount = updatedPokemonCount
        notifyDataSetChanged()
    }
}