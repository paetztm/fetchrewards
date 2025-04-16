package com.timothypaetz.android.fetchrewards.network

import retrofit2.Response
import timber.log.Timber

/**
 * Wrapper around retrofit calls to prevent exceptions and to just return null if the call fails
 */
suspend fun <T> call(fn: suspend () -> Response<T>): T? {
    return try {
        fn().value()
    } catch (e: Exception) {
        Timber.e(e)
        null
    }
}

/**
 * Logic handling for different states of a Retrofit call to either return the Network Json Object (T) or null
 */
private fun <T> Response<T>.value(): T? {
    return if (this.isSuccessful) {
        val body = this.body()
        if (body == null) {
            Timber.e("Body is null but response said it was successful")
            null
        } else {
            body
        }
    } else {
        Timber.e("Retrofit Response was unsuccessful: ${errorBody()?.byteString().toString()}")
        null
    }
}