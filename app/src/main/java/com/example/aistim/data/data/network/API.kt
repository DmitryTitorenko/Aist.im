package com.example.aistim.data.data.network

import com.example.aistim.data.model.Categories
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    companion object {
        const val BASE_URL = "https://api.aist.im/api/v1/"
    }

    @GET("catalog/categories")
    suspend fun getCategoriesList(): Categories

    @GET("catalog/categories/{category_id}")
    suspend fun getCategoriesListById(@Path("category_id") categoryId: Int)

    @GET("catalog/categories/{category_id}/products?page=1&per_page=500")
    suspend fun getCategoriesListByIdPagePerPage(@Path("category_id") categoryId: Int)

    @GET("catalog/products/{product_id}")
    suspend fun getGoodsById(@Path("product_id") categoryId: Int)

    @GET("catalog/products/search" + "?page=1&per_page=500")
    suspend fun getSearchList(@Query("query") subject: String)
}
