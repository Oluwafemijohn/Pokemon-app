package com.decagon.android.sq007.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.decagon.android.sq007.api.PokemonApi
import com.decagon.android.sq007.api.PokemonRetrofit
import com.decagon.android.sq007.controller.OnItemClickListener
import com.decagon.android.sq007.controller.PokemonAdapter
import com.decagon.android.sq007.databinding.ActivityMainBinding
import com.decagon.android.sq007.model.mainModel.PokemonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var pokeApi: PokemonApi

    lateinit var adapter: PokemonAdapter

    private val callback = object : Callback<PokemonModel> {
        override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
            Log.e("MainActivity", "Problem calling API {${t?.message}}")
        }

        override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
            response?.isSuccessful.let {
                val resultList = response.body()
                Log.d("MainActivity", "onResponse: $resultList")
                adapter = resultList?.let { it1 -> PokemonAdapter(it1, this@MainActivity, this@MainActivity) }!!
                binding.recyclerView.adapter = adapter
            }
        }
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        PokemonRetrofit.getPokemon(callback)
    }

    override fun onItemClick(position: Int, items: PokemonModel) {
        val intent = Intent()
    }
}
