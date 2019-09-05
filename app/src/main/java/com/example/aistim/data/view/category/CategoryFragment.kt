package com.example.aistim.data.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.aistim.R
import com.example.aistim.data.model.Categories
import com.example.aistim.data.view.base.BaseFragment
import dagger.Lazy
import javax.inject.Inject

class CategoryFragment : BaseFragment(), ICategoryView {

    @Inject
    lateinit var daggerPresenter: Lazy<CategoryPresenter>

    @InjectPresenter
    lateinit var presenter: CategoryPresenter

    @ProvidePresenter
    fun providePresenter(): CategoryPresenter = daggerPresenter.get()

    private var categories: Categories? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (categories == null) {
            presenter.getItems()
        } else {
            TODO("add fix ")
        }
    }

    override fun handleItems(categories: Categories) {
        this.categories = categories
        TODO("add init UI ")
    }
}
