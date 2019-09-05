package com.example.aistim.data.view.activity

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.aistim.R
import com.example.aistim.data.view.base.BaseActivity
import com.example.aistim.data.view.base.BaseView
import dagger.Lazy
import javax.inject.Inject

interface IMainView : BaseView {
}

class MainActivity : BaseActivity(), IMainView {

    @Inject
    lateinit var daggerPresenter: Lazy<MainPresenter>

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = daggerPresenter.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
