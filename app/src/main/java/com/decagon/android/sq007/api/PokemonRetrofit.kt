package com.decagon.android.sq007.api

import android.util.Log
import com.decagon.android.sq007.api.Constance.BASE_URL
import com.decagon.android.sq007.model.mainModel.PokemonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRetrofit {
    var service: PokemonApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonApi::class.java)
    }
    fun getPokemon(callBack: Callback<PokemonModel>) {
        Log.d("retrofit", "getPokemon: ")
        val call: Call<PokemonModel> = service.retrofitPokemon()
        call.enqueue(callBack)
    }
}
