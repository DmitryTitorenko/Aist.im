package com.example.aistim.data.view.category

import com.arellomobile.mvp.InjectViewState
import com.example.aistim.data.data.repository.ItemsRepo
import com.example.aistim.data.view.base.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

@InjectViewState
class CategoryPresenter @Inject constructor(private val itemsRepo: ItemsRepo) :
    BasePresenter<ICategoryView>() {

    fun getCategories(categoryCode: Int) = launch {
        if (categoryCode == 0) {
            val response = itemsRepo.loadCategories()
            viewState.handleCategories(response)
        } else {
            val response = itemsRepo.loadCategoriesListById(categoryCode)
            viewState.handleCategoriesByCode(response)
        }
    }
}
