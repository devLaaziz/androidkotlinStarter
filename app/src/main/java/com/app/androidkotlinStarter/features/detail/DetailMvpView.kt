package com.app.androidkotlinStarter.features.detail

import com.app.androidkotlinStarter.data.model.Pokemon
import com.app.androidkotlinStarter.data.model.Statistic
import com.app.androidkotlinStarter.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}