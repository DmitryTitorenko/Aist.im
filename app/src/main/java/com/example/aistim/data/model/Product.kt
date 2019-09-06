package com.example.aistim.data.model

import com.google.gson.annotations.SerializedName

data class Product(

    @field:SerializedName("data")
    val data: Data3? = null,

    @field:SerializedName("meta")
    val meta: Meta3? = null
)

data class Data3(

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("is_favorite")
    val isFavorite: Boolean? = null,

    @field:SerializedName("in_wish_list")
    val inWishList: Boolean? = null,

    @field:SerializedName("inner_id")
    val innerId: Int? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("available")
    val available: Boolean? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("details")
    val details: Details3? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("add_to_cart_url")
    val addToCartUrl: String? = null
)

data class Category3(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("has_sub_categories")
    val hasSubCategories: Boolean? = null
)

data class Meta3(

    @field:SerializedName("category")
    val category: Category3? = null
)

data class Details3(

    @field:SerializedName("Вес")
    val weight: String? = null,

    @field:SerializedName("ebsmstock")
    val ebsmstock: Boolean? = null,

    @field:SerializedName("Ширина упаковки")
    val packingWidth: String? = null,

    @field:SerializedName("Высота упаковки")
    val packingHeight: String? = null,

    @field:SerializedName("Глубина упаковки")
    val packingDepth: String? = null,

    @field:SerializedName("Тип")
    val type: String? = null,

    @field:SerializedName("crossborder")
    val crossborder: Boolean? = null,

    @field:SerializedName("Цвет")
    val color: String? = null
)