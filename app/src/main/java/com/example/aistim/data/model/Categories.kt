package com.example.aistim.data.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @field:SerializedName("data")
    val data: List<DataItem?>? = null
)

data class DataItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("has_sub_categories")
    val hasSubCategories: Boolean? = null
)
