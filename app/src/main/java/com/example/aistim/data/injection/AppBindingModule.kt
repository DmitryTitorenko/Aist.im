package com.example.aistim.data.injection

import com.example.aistim.data.view.activity.MainActivity
import com.example.aistim.data.view.category.CategoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindItemFragment(): CategoryFragment
}
