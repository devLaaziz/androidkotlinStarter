package com.app.androidkotlinStarter.injection.module

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

import dagger.Module
import dagger.Provides
import com.app.androidkotlinStarter.injection.ActivityContext

@Module
class FragmentModule(private val mFragment: Fragment) {

    @Provides
    internal fun providesFragment(): Fragment {
        return mFragment
    }

    @Provides
    internal fun provideActivity(): Activity {
        return mFragment.activity!!
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return mFragment.activity!!
    }

}