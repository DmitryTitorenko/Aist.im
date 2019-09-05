package com.example.aistim.data.view.category

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.aistim.data.model.Categories
import com.example.aistim.data.model.CategoriesByID
import com.example.aistim.data.view.base.BaseView

interface ICategoryView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun handleCategories(categories: Categories)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun handleCategoriesByCode(categoriesByID: CategoriesByID)
}
