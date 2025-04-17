package com.timothypaetz.android.fetchrewards.ui.theme.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timothypaetz.android.fetchrewards.R
import com.timothypaetz.android.fetchrewards.ui.theme.ErrorHeaderColor
import com.timothypaetz.android.fetchrewards.ui.theme.FetchRewardsTheme
import com.timothypaetz.android.fetchrewards.ui.theme.PrimaryColor

/**
 * Composable that is displayed when there is a failure.  It could be a network error, server error, or data conversion error
 */
@Composable
fun ErrorRefresh(
    onRefreshClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.base_margin)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.no_internet_icon),
                contentDescription = stringResource(R.string.server_error)
            )
            Text(
                text = stringResource(id = R.string.server_error),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.spacer)),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = ErrorHeaderColor,
            )
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.spacer)),
                shape = RoundedCornerShape(25),
                border = BorderStroke(
                    2.dp,
                    PrimaryColor
                ),
                onClick = onRefreshClicked
            ) {
                Text(
                    text = stringResource(R.string.try_again),
                    style = MaterialTheme.typography.bodyLarge,
                    color = PrimaryColor,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewErrorRefresh() {
    FetchRewardsTheme {
        ErrorRefresh {

        }
    }
}