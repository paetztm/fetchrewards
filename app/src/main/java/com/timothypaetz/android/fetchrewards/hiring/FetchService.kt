package com.timothypaetz.android.fetchrewards.hiring

import retrofit2.Response
import retrofit2.http.GET

interface FetchService {

    @GET("hiring.json")
    suspend fun getHiringData(): Response<List<HiringNetworkData>>

}