package com.timothypaetz.android.fetchrewards.hiring

import com.timothypaetz.android.fetchrewards.core.CoreViewModel
import com.timothypaetz.android.fetchrewards.network.Api
import com.timothypaetz.android.fetchrewards.network.FetchService
import com.timothypaetz.android.fetchrewards.network.call

/**
 * ViewModel for the [HiringScreen] composable
 */
class HiringViewModel(
    private val fetchService: FetchService = Api.fetchService
) : CoreViewModel<Map<Long, List<HiringViewData>>>(
    {
        call {
            fetchService.getHiringData()
        }?.mapNotNull {
            it.toUI()
        }?.sortedWith(compareBy<HiringViewData> { it.listId }.thenBy { it.name })?.groupBy { it.listId }
    }
)