package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@Preview
fun ContentSlide(
    title: String,
    content: @Composable() (BoxScope.() -> Unit),
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Heading(pageTitle = title)
        Box { content() }
    }
}