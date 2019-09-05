package com.example.aistim.data.model

import com.google.gson.annotations.SerializedName

data class Products(

    @field:SerializedName("data")
    val data: List<DataItem1?>? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("links")
    val links: Links? = null
)

data class Meta(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("per_page")
    val perPage: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("last_page")
    val lastPage: Int? = null,

    @field:SerializedName("from")
    val from: Int? = null,

    @field:SerializedName("to")
    val to: Int? = null,

    @field:SerializedName("category")
    val category: Category? = null,

    @field:SerializedName("current_page")
    val currentPage: Int? = null
)

data class Links(

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("last")
    val last: String? = null,

    @field:SerializedName("prev")
    val prev: Any? = null,

    @field:SerializedName("first")
    val first: String? = null
)

data class DataItem1(

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
    val details: Details? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("add_to_cart_url")
    val addToCartUrl: String? = null
)

data class Category(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("has_sub_categories")
    val hasSubCategories: Boolean? = null
)

data class Details(

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

    @field:SerializedName("Комплектация")
    val equipment: String? = null,

    @field:SerializedName("Упаковка")
    val packaging: String? = null,

    @field:SerializedName("crossborder")
    val crossborder: Boolean? = null,

    @field:SerializedName("Цвет")
    val color: String? = null
)