package com.timothypaetz.android.fetchrewards.network

import com.squareup.moshi.Moshi
import com.timothypaetz.android.fetchrewards.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

/**
 * Api singleton.  Nice to have would be to add Hilt but since there is only one dependency, I do
 * not think that is needed
 */
object Api {

    private val okhttpClient by lazy {
        OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor { message -> Timber.d(message) }
                .apply {
                    level = if (BuildConfig.DEBUG)
                        HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }
            ).build()
    }

    private val moshi by lazy {
        MoshiConverterFactory.create(Moshi.Builder().build())
    }

    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    val fetchService: FetchService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(
                moshi
            ).build()
        retrofit.create(FetchService::class.java)
    }

}