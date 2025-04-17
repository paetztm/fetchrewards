package com.timothypaetz.android.fetchrewards.network

import com.timothypaetz.android.fetchrewards.hiring.HiringNetworkData
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit interface for calling Fetch Rewards endpoints
 */
interface FetchService {

    @GET("hiring.json")
    suspend fun getHiringData(): Response<List<HiringNetworkData>>

}