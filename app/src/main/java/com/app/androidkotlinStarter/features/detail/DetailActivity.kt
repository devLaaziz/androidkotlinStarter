package com.app.androidkotlinStarter.features.detail

import com.app.androidkotlinStarter.R
import com.app.androidkotlinStarter.data.model.Pokemon
import com.app.androidkotlinStarter.data.model.Statistic
import com.app.androidkotlinStarter.features.base.BaseActivity
import com.app.androidkotlinStarter.features.common.ErrorView
import com.app.androidkotlinStarter.features.detail.widget.StatisticView
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import com.bumptech.glide.Glide
import timber.log.Timber
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailMvpView, ErrorView.ErrorListener {

    @Inject lateinit var mDetailPresenter: DetailPresenter

    @BindView(R.id.view_error) @JvmField var mErrorView: ErrorView? = null
    @BindView(R.id.image_pokemon) @JvmField var mPokemonImage: ImageView? = null
    @BindView(R.id.progress) @JvmField var mProgress: ProgressBar? = null
    @BindView(R.id.toolbar) @JvmField var mToolbar: Toolbar? = null
    @BindView(R.id.layout_stats) @JvmField var mStatLayout: LinearLayout? = null
    @BindView(R.id.layout_pokemon) @JvmField var mPokemonLayout: View? = null

    private var mPokemonName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        mDetailPresenter.attachView(this)

        mPokemonName = intent.getStringExtra(EXTRA_POKEMON_NAME)
        if (mPokemonName == null) {
            throw IllegalArgumentException("Detail Activity requires a pokemon name@")
        }

        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = mPokemonName?.substring(0, 1)?.toUpperCase() + mPokemonName?.substring(1)

        mErrorView?.setErrorListener(this)

        mDetailPresenter.getPokemon(mPokemonName as String)
    }

    override val layout: Int
        get() = R.layout.activity_detail

    override fun showPokemon(pokemon: Pokemon) {
        if (pokemon.sprites.frontDefault != null) {
            Glide.with(this)
                    .load(pokemon.sprites.frontDefault)
                    .into(mPokemonImage!!)
        }
        mPokemonLayout?.visibility = View.VISIBLE
    }

    override fun showStat(statistic: Statistic) {
        val statisticView = StatisticView(this)
        statisticView.setStat(statistic)
        mStatLayout?.addView(statisticView)
    }

    override fun showProgress(show: Boolean) {
        mErrorView?.visibility = View.GONE
        mProgress?.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(error: Throwable) {
        mPokemonLayout?.visibility = View.GONE
        mErrorView?.visibility = View.VISIBLE
        Timber.e(error, "There was a problem retrieving the pokemon...")
    }

    override fun onReloadData() {
        mDetailPresenter.getPokemon(mPokemonName as String)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDetailPresenter.detachView()
    }

    companion object {

        val EXTRA_POKEMON_NAME = "EXTRA_POKEMON_NAME"

        fun getStartIntent(context: Context, pokemonName: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_POKEMON_NAME, pokemonName)
            return intent
        }
    }
}