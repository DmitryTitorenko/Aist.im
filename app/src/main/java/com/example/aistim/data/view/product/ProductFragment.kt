package com.example.aistim.data.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.aistim.R
import com.example.aistim.data.model.Product
import com.example.aistim.data.view.base.BaseFragment
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.android.synthetic.main.fragment_products.btnBack
import javax.inject.Inject

class ProductFragment : BaseFragment(), IProductView {
    @Inject
    lateinit var daggerPresenter: Lazy<ProductPresenter>

    @InjectPresenter
    lateinit var presenter: ProductPresenter

    @ProvidePresenter
    fun providePresenter(): ProductPresenter = daggerPresenter.get()

    lateinit var product: Product

    private var productCode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("productCode")?.let {
            productCode = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBtnBack()
        presenter.getProductById(productCode)
    }

    override fun handleProduct(product: Product) {
        this.product = product
        initUI()
    }

    private fun initUI() {
        product.data?.let { data ->
            data.price?.let {
                tvPrise.text = it.toString() + " \u20BD"
            }
            data.name?.let {
                tvTitle.text = it
            }
            data.images?.let { listUri ->
                listUri[0]?.let { uri ->
                    loadImage(uri, imageView)
                }
            }
        }
    }

    private fun loadImage(uri: String, ivProduct: ImageView) {
        Glide.with(requireContext())
            .load(uri)
            .into(ivProduct)
    }

    private fun setBtnBack() {
        btnBack.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }
    }
}
