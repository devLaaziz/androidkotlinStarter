package com.laaziz.bestlib.common.injection.component

import com.laaziz.bestlib.common.injection.module.ApplicationTestModule
import com.laaziz.bestlib.injection.component.ApplicationComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : ApplicationComponent