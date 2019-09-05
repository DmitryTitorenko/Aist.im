package com.example.aistim.data.data.repository

import com.example.aistim.data.data.network.API
import com.example.aistim.data.model.Categories
import com.example.aistim.data.model.CategoriesByID
import com.example.aistim.data.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemsRepo @Inject constructor(
    private val api: API
) {

    suspend fun loadCategories(): Categories = withContext(Dispatchers.IO) {
        return@withContext api.getCategoriesList()
    }

    suspend fun loadCategoriesListById(categoryCode: Int): CategoriesByID =
        withContext(Dispatchers.IO) {
            return@withContext api.getCategoriesListById(categoryCode)
        }

    suspend fun loadCategoriesListByIdPagePerPage(categoryCode: Int): Products =
        withContext(Dispatchers.IO) {
            return@withContext api.getCategoriesListByIdPagePerPage(categoryCode)
        }

}
