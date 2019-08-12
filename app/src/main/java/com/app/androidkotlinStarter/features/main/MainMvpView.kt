package com.app.androidkotlinStarter.features.main

import com.app.androidkotlinStarter.features.base.MvpView

interface MainMvpView : MvpView {

    fun showPokemon(pokemon: List<String>)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}