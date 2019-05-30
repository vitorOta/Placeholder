package com.vitorota.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Vitor Ota
 * @since 29/05/2019
 */
object ApiClientBuilder {
    private val defaultClient = OkHttpClient()

    fun <S> createServiceApi(
        serviceClass: Class<S>,
        baseUrl: String,
        gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create(),
        vararg interceptors: Interceptor
    ): S {
        val clientBuilder = defaultClient.newBuilder()
        interceptors.forEach { clientBuilder.addInterceptor(it) }
        val client = clientBuilder.build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(serviceClass)
    }
}