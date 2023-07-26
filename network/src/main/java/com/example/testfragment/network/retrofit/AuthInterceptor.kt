package com.example.testfragment.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    private val token = "5Jo2ECFCeqIiH34p6/YAFg==SLZ7boyWqSDovZ3P"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        //val finalToken = "$token"
        request.newBuilder()
            .addHeader("X-Api-Key", token)
            .build()
        return chain.proceed(request)
    }
}