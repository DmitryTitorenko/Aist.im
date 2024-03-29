package com.example.aistim.data.data.network

import com.example.aistim.data.model.Categories
import com.example.aistim.data.model.CategoriesByID
import com.example.aistim.data.model.Product
import com.example.aistim.data.model.Products
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
    suspend fun getCategoriesListById(@Path("category_id") categoryId: Int): CategoriesByID

    @GET("catalog/categories/{category_id}/products?page=1&per_page=100")
    suspend fun getCategoriesListByIdPagePerPage(@Path("category_id") categoryId: Int): Products

    @GET("catalog/products/{product_id}")
    suspend fun getProductById(@Path("product_id") productID: Int): Product

    @GET("catalog/products/search" + "?page=1&per_page=500")
    suspend fun getSearchList(@Query("query") subject: String)
}
