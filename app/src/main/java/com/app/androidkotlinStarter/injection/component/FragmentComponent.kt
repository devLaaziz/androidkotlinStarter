package com.app.androidkotlinStarter.injection.component

import com.app.androidkotlinStarter.injection.PerFragment
import com.app.androidkotlinStarter.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent