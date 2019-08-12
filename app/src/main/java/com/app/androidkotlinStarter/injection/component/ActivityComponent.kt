package com.app.androidkotlinStarter.injection.component

import com.app.androidkotlinStarter.injection.PerActivity
import com.app.androidkotlinStarter.injection.module.ActivityModule
import com.app.androidkotlinStarter.features.base.BaseActivity
import com.app.androidkotlinStarter.features.detail.DetailActivity
import com.app.androidkotlinStarter.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
