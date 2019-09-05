package com.example.aistim.data.view.product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aistim.R
import com.example.aistim.data.model.DataItem1
import kotlinx.android.synthetic.main.product.view.*

class ProductAdapter(
    private val categoryList: List<DataItem1?>,
    private val context: Context
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var onItemClick: ((DataItem1) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product, parent, false)
        return ViewHolder(view).apply {
            view.setOnClickListener {
                categoryList[adapterPosition]?.let {
                    onItemClick?.invoke(it)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        categoryList[position]?.let {
            holder.tvTitle.text = it.name
            holder.tvPrise.text = it.price.toString() + " \u20BD"
            it.images?.let { listUri ->
                listUri[0]?.let { uri ->
                    loadImage(uri, holder.ivProduct)
                }
            }
        }
    }

    override fun getItemCount() = categoryList.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val ivProduct: ImageView = view.ivProduct
        val tvTitle: TextView = view.tvTitle
        val tvPrise: TextView = view.tvPrise
    }

    private fun loadImage(uri: String, ivProduct: ImageView) {
        Glide.with(context)
            .load(uri)
            //.apply(bitmapTransform(getRoundedBottomCorners()))
            .into(ivProduct)
    }
}