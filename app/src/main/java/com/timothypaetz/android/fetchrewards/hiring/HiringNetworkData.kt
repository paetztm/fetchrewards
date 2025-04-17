package com.timothypaetz.android.fetchrewards.hiring

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Network object representing data returned from
 * https://fetch-hiring.s3.amazonaws.com/hiring.json
 */
@JsonClass(generateAdapter = true)
data class HiringNetworkData(
    @Json(name = "id")
    val id: Long,
    @Json(name = "listId")
    val listId: Long,
    @Json(name = "name")
    val name: String?,
)
