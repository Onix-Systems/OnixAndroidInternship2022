package com.onix.network.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.onix.network.BuildConfig
import com.onix.network.auth.AuthInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object NetworkProvider {

    private const val OKHTTP_READ_TIMEOUT: Long = 60
    private const val OKHTTP_CONNECT_TIMEOUT = 30L

    fun <T> provideApiService(
        authInterceptor: AuthInterceptor,
        gson: Gson,
        baseUrl: String,
        service: Class<T>
    ): T {
        return provideRetrofitBuilder(authInterceptor, gson)
            .baseUrl(baseUrl).build().create(service)
    }

    private fun provideRetrofitBuilder(
        authInterceptor: AuthInterceptor, gson: Gson
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(provideOkHttp(authInterceptor))
    }

    private fun provideOkHttp(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(provideLoggingInterceptor())
            .readTimeout(OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    fun provideGson(): Gson = GsonBuilder().create()

    private fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else HttpLoggingInterceptor.Level.NONE
            )
    }
}