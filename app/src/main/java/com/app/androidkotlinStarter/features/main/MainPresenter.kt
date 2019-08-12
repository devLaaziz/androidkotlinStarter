package com.app.androidkotlinStarter.features.main

import com.app.androidkotlinStarter.data.DataManager
import com.app.androidkotlinStarter.injection.ConfigPersistent
import com.app.androidkotlinStarter.features.base.BasePresenter
import com.app.androidkotlinStarter.util.rx.scheduler.SchedulerUtils
import javax.inject.Inject

@ConfigPersistent
class MainPresenter @Inject
constructor(private val mDataManager: DataManager) : BasePresenter<MainMvpView>() {

    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    fun getPokemon(limit: Int) {
        checkViewAttached()
        mvpView?.showProgress(true)
        mDataManager.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({ pokemons ->
                    mvpView?.showProgress(false)
                    mvpView?.showPokemon(pokemons)
                }) { throwable ->
                    mvpView?.showProgress(false)
                    mvpView?.showError(throwable)
                }
    }

}