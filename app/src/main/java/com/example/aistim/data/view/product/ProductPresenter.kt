package com.example.aistim.data.view.product

import com.arellomobile.mvp.InjectViewState
import com.example.aistim.data.data.repository.ItemsRepo
import com.example.aistim.data.view.base.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class ProductPresenter @Inject constructor(private val itemsRepo: ItemsRepo) :
    BasePresenter<IProductView>() {

    fun getProductById(productID: Int) = launch {
        val response = itemsRepo.loadProductById(productID)
        viewState.handleProduct(response)
    }
}
