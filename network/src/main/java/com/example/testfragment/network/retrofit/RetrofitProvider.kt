package com.example.testfragment.network.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseUrl {
    const val BASE_URL = "https://api.api-ninjas.com/v1/"
}

fun provideOkHttpClient(interceptors: List<Interceptor>): OkHttpClient =
    OkHttpClient().newBuilder().apply {
        interceptors.map { addInterceptor(it) }
    }.build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BaseUrl.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()