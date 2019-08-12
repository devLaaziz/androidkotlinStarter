package com.app.androidkotlinStarter.injection.component

import com.app.androidkotlinStarter.data.DataManager
import com.app.androidkotlinStarter.data.remote.MvpStarterService
import com.app.androidkotlinStarter.injection.ApplicationContext
import com.app.androidkotlinStarter.injection.module.ApplicationModule
import android.app.Application
import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun mvpBoilerplateService(): MvpStarterService
}
