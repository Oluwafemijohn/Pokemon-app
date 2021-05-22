package com.decagon.android.sq007.api

import com.decagon.android.sq007.model.mainModel.PokemonModel
import com.decagon.android.sq007.model.subModel.PokemonSubModel
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {
    @GET("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200")
    fun retrofitPokemon(): Call<PokemonModel>

    fun getPokemonImage(): Call<PokemonSubModel>
}
