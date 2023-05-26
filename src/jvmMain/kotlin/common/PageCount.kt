package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import title

@Composable
@Preview
fun BoxScope.PageCount(
    pageNumber: Int,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.align(Alignment.BottomStart),
        text = "$pageNumber | $title",
        style = MaterialTheme.typography.overline
    )
}