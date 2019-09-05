package com.example.aistim.data.model

import com.google.gson.annotations.SerializedName

data class CategoriesByID(

    @field:SerializedName("data")
    val data: Data? = null
)

data class Data(

    @field:SerializedName("sub_categories")
    val subCategories: List<DataItem?>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("has_sub_categories")
    val hasSubCategories: Boolean? = null
)
