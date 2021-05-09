package com.decagon.android.sq007.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.decagon.android.sq007.controller.OnItemClickListener
import com.decagon.android.sq007.databinding.ActivityMainBinding
import com.decagon.android.sq007.model.PokemonModel

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onItemClick(position: Int, items: List<PokemonModel>) {
        var intent = Intent(this, PokemonDetailsActivity::class.java)
        startActivity(intent)
    }
}
