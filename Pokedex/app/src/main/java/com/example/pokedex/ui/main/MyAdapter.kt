package com.example.pokedex.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.my_row_3.view.*
import kotlinx.android.synthetic.main.my_row_3.view.*

class MyAdapter(private val dataSet: Array<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val linearlayout_row_3: LinearLayout
        init {
            linearlayout_row_3 = row3
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.my_row_3,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position%3 == 0){
            holder.linearlayout_row_3.cardview_row_3_1.constraintlayout_row3_1.imageview_row3_1.setImageResource(dataSet[position].image)
            holder.linearlayout_row_3.cardview_row_3_1.constraintlayout_row3_1.textview_row3_1.setText(dataSet[position].text)
        } else if(position%3 == 1) {
            holder.linearlayout_row_3.cardview_row_3_2.constraintlayout_row3_2.imageview_row3_2.setImageResource(dataSet[position].image)
            holder.linearlayout_row_3.cardview_row_3_2.constraintlayout_row3_2.textview_row3_2.setText(dataSet[position].text)
        } else {
            holder.linearlayout_row_3.cardview_row_3_3.constraintlayout_row3_3.imageview_row3_3.setImageResource(dataSet[position].image)
            holder.linearlayout_row_3.cardview_row_3_3.constraintlayout_row3_3.textview_row3_3.setText(dataSet[position].text)
        }
    }

    override fun getItemCount(): Int{
        dataSet.size
    }
}