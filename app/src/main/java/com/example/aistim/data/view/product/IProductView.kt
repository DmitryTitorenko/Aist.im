package com.example.aistim.data.view.product

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.aistim.data.model.Product
import com.example.aistim.data.view.base.BaseView

interface IProductView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun handleProduct(product: Product)
}
