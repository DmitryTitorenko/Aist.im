package com.example.aistim.data.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.aistim.R
import com.example.aistim.data.model.Categories
import com.example.aistim.data.model.CategoriesByID
import com.example.aistim.data.model.DataItem
import com.example.aistim.data.view.base.BaseFragment
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_items.*
import javax.inject.Inject

class CategoryFragment : BaseFragment(), ICategoryView {

    @Inject
    lateinit var daggerPresenter: Lazy<CategoryPresenter>

    @InjectPresenter
    lateinit var presenter: CategoryPresenter

    @ProvidePresenter
    fun providePresenter(): CategoryPresenter = daggerPresenter.get()

    private var categoriesList: List<DataItem?>? = null
    private var isMainCategory = true
    private var categoryCode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getInt("categoryCode")?.let {
            isMainCategory = false
            categoryCode = it
        }
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
        if (categoriesList == null) {
            presenter.getCategories(categoryCode)
        } else {
            setAdapter()
        }
        setBtnBack()
    }

    override fun handleCategories(categories: Categories) {
        this.categoriesList = categories.data
        setAdapter()
    }

    override fun handleCategoriesByCode(categoriesByID: CategoriesByID) {
        this.categoriesList = categoriesByID.data?.subCategories
        tvTitle.text = categoriesByID.data?.name
        setAdapter()
    }

    private fun setAdapter() {
        categoriesList?.let { list ->
            val adapter = CategoryAdapter(list)
            rvCategories.adapter = adapter
            rvCategories.layoutManager = LinearLayoutManager(this.context)
            adapter.onItemClick = {
                startSelectedCategory(it)
            }
        }
    }

    private fun startSelectedCategory(category: DataItem) {
        val bundle = bundleOf()
        category.id?.let { categoryCode ->
            bundle.putInt("categoryCode", categoryCode)
        }
        view?.findNavController()?.navigate(R.id.action_itemFragment_self, bundle)
    }

    private fun setBtnBack() {
        btnBack.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }
    }
}
