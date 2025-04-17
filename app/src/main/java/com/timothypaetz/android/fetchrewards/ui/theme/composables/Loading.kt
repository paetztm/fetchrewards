package com.timothypaetz.android.fetchrewards.ui.theme.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.timothypaetz.android.fetchrewards.ui.theme.FetchRewardsTheme

/**
 * Composable to display a Circular Progress Bar
 */
@Composable
fun Loading(
    size: Dp = 48.dp,
) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(size),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewLoading() {
    FetchRewardsTheme {
        Loading()
    }
}