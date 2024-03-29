package com.example.aistim.data.view.products

import com.arellomobile.mvp.InjectViewState
import com.example.aistim.data.data.repository.ItemsRepo
import com.example.aistim.data.view.base.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class ProductsPresenter @Inject constructor(private val itemsRepo: ItemsRepo) :
    BasePresenter<IProductsView>() {

    fun getCategoriesListByIdPagePerPage(categoryCode: Int) = launch {
        val response = itemsRepo.loadCategoriesListByIdPagePerPage(categoryCode)
        viewState.handleProducts(response)
    }
}