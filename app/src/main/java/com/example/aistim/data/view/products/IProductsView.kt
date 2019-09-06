package com.example.aistim.data.view.products

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.aistim.data.model.Products
import com.example.aistim.data.view.base.BaseView

interface IProductsView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun handleProducts(products: Products)
}