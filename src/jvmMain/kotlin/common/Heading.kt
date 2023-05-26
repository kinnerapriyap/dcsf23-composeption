package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
@Preview
fun Heading(
    pageTitle: String,
    topic: String? = null,
) {
    topic?.let {
        Text(
            text = topic,
            style = MaterialTheme.typography.subtitle1,
        )
    }
    Text(
        text = pageTitle,
        style = MaterialTheme.typography.h3,
    )
}