package com.example.testfragment.network.di

import com.example.testfragment.network.retrofit.AuthInterceptor
import com.example.testfragment.network.retrofit.provideLoggingInterceptor
import com.example.testfragment.network.retrofit.provideOkHttpClient
import com.example.testfragment.network.retrofit.provideRetrofit
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val networkModule = module {
    single { AuthInterceptor() }
    single { provideLoggingInterceptor() }
    single {
        provideOkHttpClient(
            interceptors = listOf(
                get<AuthInterceptor>(),
                get<HttpLoggingInterceptor>(),
            )
        )
    }
    single { provideRetrofit(okHttpClient = get()) }
}