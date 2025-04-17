package com.timothypaetz.android.fetchrewards.hiring

/**
 * Converts [HiringNetworkData] to [HiringViewData] or null if the network data is incomplete
 */
fun HiringNetworkData.toUI(): HiringViewData? {
    return HiringViewData(
        id = this.id,
        listId = this.listId,
        name = if (this.name.isNullOrBlank()) return null else this.name
    )
}