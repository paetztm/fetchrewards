package com.timothypaetz.android.fetchrewards.hiring

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class HiringDataConverterKtTest {

    @Test
    fun `HiringNetworkData to HiringViewData toUI happy path test`() {
        // given
        val networkData = HiringNetworkData(1L, 100L, "Hello World")
        val expected = HiringViewData(1L, 100L, "Hello World")

        // when
        val result = networkData.toUI()

        // then
        assertEquals(expected, result)
    }

    @Test
    fun `HiringNetworkData to HiringViewData toUI empty name test`() {
        // given
        val networkData = HiringNetworkData(1L, 100L, "")

        // when
        val result = networkData.toUI()

        // then
        assertNull(result)
    }

    @Test
    fun `HiringNetworkData to HiringViewData toUI null name test`() {
        // given
        val networkData = HiringNetworkData(1L, 100L, null)

        // when
        val result = networkData.toUI()

        // then
        assertNull(result)
    }
}