package com.example.aistim.data.view.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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

class ProductsFragment : BaseFragment(), IProductsView {
    @Inject
    lateinit var daggerPresenter: Lazy<ProductsPresenter>

    @InjectPresenter
    lateinit var presenter: ProductsPresenter

    @ProvidePresenter
    fun providePresenter(): ProductsPresenter = daggerPresenter.get()

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
            val adapter = ProductsAdapter(list, requireContext())
            rvProducts.adapter = adapter
            rvProducts.layoutManager = GridLayoutManager(this.context, 2)
            adapter.onItemClick = {
                it.id?.let { productCode ->
                    startSelectedProduct(productCode)
                }
            }
        }
    }

    private fun startSelectedProduct(productCode: Int) {
        val bundle = bundleOf()
        bundle.putInt("productCode", productCode)
        view?.findNavController()
            ?.navigate(R.id.action_productFragment_to_productSelected, bundle)
    }

    private fun setBtnBack() {
        btnBack.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }
    }
}