package com.example.aistim.data.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.aistim.R
import com.example.aistim.data.model.DataItem1
import com.example.aistim.data.model.Products
import com.example.aistim.data.view.base.BaseFragment
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_products.*
import javax.inject.Inject

class ProductFragment : BaseFragment(), IProductView {
    @Inject
    lateinit var daggerPresenter: Lazy<ProductPresenter>

    @InjectPresenter
    lateinit var presenter: ProductPresenter

    @ProvidePresenter
    fun providePresenter(): ProductPresenter = daggerPresenter.get()

    private var productsList: List<DataItem1?>? = null

    private var categoryCode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("categoryCode")?.let {
            categoryCode = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBtnBack()
        presenter.getCategoriesListByIdPagePerPage(categoryCode)
    }

    override fun handleProducts(products: Products) {
        this.productsList = products.data
        setAdapter()
    }

    private fun setAdapter() {
        productsList?.let { list ->
            val adapter = ProductAdapter(list, requireContext())
            rvProducts.adapter = adapter
            rvProducts.layoutManager = GridLayoutManager(this.context, 2)
            adapter.onItemClick = {
                //  startSelectedCategory(it)
            }
        }
    }

    private fun setBtnBack() {
        btnBack.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }
    }
}