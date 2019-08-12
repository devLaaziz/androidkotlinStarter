package com.app.androidkotlinStarter.data.remote


import com.app.androidkotlinStarter.data.model.Pokemon
import com.app.androidkotlinStarter.data.model.PokemonListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MvpStarterService {

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int): Single<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Single<Pokemon>

}
