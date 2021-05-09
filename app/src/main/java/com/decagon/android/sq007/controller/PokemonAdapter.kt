package com.decagon.android.sq007.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.decagon.android.sq007.databinding.CardviewBinding
import com.decagon.android.sq007.model.PokemonModel

class PokemonAdapter(var items: List<PokemonModel>, private val listener: OnItemClickListener, private val context: Context) :
    RecyclerView.Adapter<PokemonAdapter.CardViewHolder>() {

    inner class CardViewHolder constructor(val binding: CardviewBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        fun bind(pokemonModel: PokemonModel) {
            binding.pokemonTitle.text = pokemonModel.name
            binding.pokemonAbility.text = pokemonModel.abilities[0].ability.name
            Glide.with(context).load(items[adapterPosition])
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

interface OnItemClickListener {
    fun onItemClick(position: Int, items: List<PokemonModel>)
}
