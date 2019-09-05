package com.example.aistim.data.injection

import com.example.aistim.data.data.network.API
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class APIModule {
    @Provides
    @Singleton
    fun buildRetrofitConfig(): API {
        val httpClient = getBaseHttpConfig()
        val retrofit = Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        return retrofit.build().create(API::class.java)
    }

    private fun getBaseHttpConfig(): OkHttpClient.Builder {
        val log = HttpLoggingInterceptor()
        log.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(log)
        okHttpClient.addInterceptor {
            var request = it.request()
            var builder = request.newBuilder()
            builder.addHeader("X-Auth-Id", "1")
            builder.addHeader("X-Session-Id", "922803673")
            builder.addHeader("X-Locale", "ru")
            request = builder.build()
            it.proceed(request)
        }
        return okHttpClient
    }
}
