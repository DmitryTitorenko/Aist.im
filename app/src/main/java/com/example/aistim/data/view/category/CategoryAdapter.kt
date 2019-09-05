package com.example.aistim.data.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aistim.R
import com.example.aistim.data.model.DataItem

class CategoryAdapter(
    private val categoryList: List<DataItem?>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onItemClick: ((DataItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val title = LayoutInflater.from(parent.context)
            .inflate(R.layout.category, parent, false) as TextView
        return ViewHolder(title).apply {
            title.setOnClickListener {
                categoryList[adapterPosition]?.let {
                    onItemClick?.invoke(it)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        categoryList[position]?.let {
            holder.title.text = it.name
        }
    }

    override fun getItemCount() = categoryList.size

    class ViewHolder(val title: TextView) : RecyclerView.ViewHolder(title)
}
