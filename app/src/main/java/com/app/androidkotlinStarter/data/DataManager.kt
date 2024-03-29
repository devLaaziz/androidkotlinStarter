package com.app.androidkotlinStarter.data

import com.app.androidkotlinStarter.data.model.Pokemon
import com.app.androidkotlinStarter.data.remote.MvpStarterService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject
constructor(private val mMvpStarterService: MvpStarterService) {

    fun getPokemonList(limit: Int): Single<List<String>> {
        return mMvpStarterService.getPokemonList(limit)
                .toObservable()
                .flatMapIterable { (results) -> results }
                .map { (name) -> name }
                .toList()
    }

    fun getPokemon(name: String): Single<Pokemon> {
        return mMvpStarterService.getPokemon(name)
    }

}