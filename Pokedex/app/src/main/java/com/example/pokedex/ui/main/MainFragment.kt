package com.example.pokedex.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.my_row_3.view.*

class MainFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(MainRepository())
        ).get(MainViewModel::class.java)

        viewModel.pokemonLiveData.observe(viewLifecycleOwner, Observer { pokemons ->
            val row3 = layoutInflater.inflate(R.layout.my_row_3,null)
            row3.linearlayout_row_3.cardview_row_3_1.constraintlayout_row3_1.imageview_row3_1.setImageResource(R.mipmap.bulbassaur)
            row3.linearlayout_row_3.cardview_row_3_2.constraintlayout_row3_2.imageview_row3_2.setImageResource(R.mipmap.charmander)
            row3.linearlayout_row_3.cardview_row_3_3.constraintlayout_row3_3.imageview_row3_3.setImageResource(R.mipmap.squirtle)
            row3.linearlayout_row_3.cardview_row_3_1.constraintlayout_row3_1.textview_row3_1.setText("Bulbassaur")
            row3.linearlayout_row_3.cardview_row_3_2.constraintlayout_row3_2.textview_row3_2.setText("Charmander")
            row3.linearlayout_row_3.cardview_row_3_3.constraintlayout_row3_3.textview_row3_3.setText("Squirtle")
            pokedex.addView(row3)
            pokedex.addView(row3)
            pokedex.addView(row3)
            pokedex.addView(row3)
            pokedex.addView(row3)
        })
    }

}