package com.timothypaetz.android.fetchrewards.hiring

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class HiringScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyDataIsDisplayed() {
        // given
        val fakeData = mapOf(
            100L to listOf(
                HiringViewData(1L, 100L, "Hello"),
                HiringViewData(2L, 100L, "World"),
                HiringViewData(3L, 100L, "Foo"),
                HiringViewData(4L, 100L, "Bar"),
            )
        )

        // when
        composeTestRule.setContent { HiringScreen(fakeData) }

        // then
        with(composeTestRule) {
            onNodeWithText("100").assertIsDisplayed()
            onNodeWithText("Hello").assertIsDisplayed()
            onNodeWithText("World").assertIsDisplayed()
            onNodeWithText("Foo").assertIsDisplayed()
            onNodeWithText("Bar").assertIsDisplayed()
        }
    }
}