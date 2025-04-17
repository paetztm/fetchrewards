package com.timothypaetz.android.fetchrewards.hiring

import com.timothypaetz.android.fetchrewards.core.CoreViewModelState
import com.timothypaetz.android.fetchrewards.network.FetchService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

class HiringViewModelTest {

    @Test
    fun `verify HiringViewData returned is correct`() = runTest {
        // given
        val networkData = listOf(
            HiringNetworkData(1L, 100L, "Hello World"),
            HiringNetworkData(2L, 200L, ""),
            HiringNetworkData(3L, 300L, null),
        )
        val expected = CoreViewModelState.Success(
            mapOf(
                100L to listOf(HiringViewData(1L, 100L, "Hello World"))
            )
        )
        val fetchService = mockk<FetchService>()
        coEvery { fetchService.getHiringData() } returns Response.success(networkData)

        // when
        val vm = HiringViewModel(fetchService)
        val results = vm.uiState.take(1).toList()

        // then
        assertEquals(
            expected,
            results[0]
        )
    }
}