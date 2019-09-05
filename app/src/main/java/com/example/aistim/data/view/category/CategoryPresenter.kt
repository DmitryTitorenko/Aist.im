package com.example.aistim.data.view.category

import com.arellomobile.mvp.InjectViewState
import com.example.aistim.data.data.repository.ItemsRepo
import com.example.aistim.data.view.base.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class CategoryPresenter @Inject constructor(private val itemsRepo: ItemsRepo) :
    BasePresenter<ICategoryView>() {

    fun getItems() = launch {
        val response = itemsRepo.loadCategories()
        viewState.handleItems(response)
    }
}
