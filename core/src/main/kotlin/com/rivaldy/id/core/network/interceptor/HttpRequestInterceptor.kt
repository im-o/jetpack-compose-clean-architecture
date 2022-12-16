package com.rivaldy.id.core.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/** Created by github.com/im-o on 12/16/2022. */

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        Log.d("HttpRequestInterceptor", "intercept: $request")
        return chain.proceed(request)
    }
}