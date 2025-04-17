package com.timothypaetz.android.fetchrewards.hiring

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.timothypaetz.android.fetchrewards.R
import com.timothypaetz.android.fetchrewards.core.ViewStateCoordinator
import com.timothypaetz.android.fetchrewards.ui.theme.BackgroundGray
import com.timothypaetz.android.fetchrewards.ui.theme.FetchRewardsTheme

/**
 * UI for displaying the [HiringViewData]
 */
@Composable
fun HiringScreen(
    vm: HiringViewModel = viewModel()
) {
    ViewStateCoordinator(vm) {
        HiringScreen(it)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HiringScreen(hiringData: Map<Long, List<HiringViewData>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = dimensionResource(R.dimen.base_margin))
    ) {
        hiringData.forEach { (listId, hirings) ->
            // if you use recycler views, you can use this really old code for sticky headers :)
            // https://github.com/paetztm/recycler_view_headers
            stickyHeader {
                Text(
                    text = "$listId",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundGray)
                        .padding(
                            horizontal = dimensionResource(R.dimen.base_margin),
                            vertical = dimensionResource(R.dimen.spacer),
                        ),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            itemsIndexed(hirings) { index, it ->
                Text(
                    text = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.spacer)),
                    style = MaterialTheme.typography.bodyMedium,
                )

                if (index != hirings.size - 1)
                    HorizontalDivider()
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun HiringScreenPreview() {
    val fakeData = mapOf(
        100L to listOf(
            HiringViewData(1L, 100L, "Hello"),
            HiringViewData(2L, 200L, "World"),
            HiringViewData(3L, 300L, "Foo"),
            HiringViewData(4L, 400L, "Bar"),
        )
    )
    FetchRewardsTheme {
        HiringScreen(
            fakeData
        )
    }
}