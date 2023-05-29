package slides

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import common.Heading

@Composable
@Preview
fun BoxScope.ContentSlide(
    title: String,
    content: @Composable BoxScope.() -> Unit,
) {
    Heading(pageTitle = title)
    content()
}