package slides

import NavEvent
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.Heading
import common.Slide

@Composable
@Preview
fun ContentSlide(
    title: String,
    handleNavigation: (NavEvent) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Slide(
        onMenuClicked = { handleNavigation(NavEvent.onMenuClicked) },
        onNextClicked = { handleNavigation(NavEvent.onNextClicked) },
        modifier = modifier,
        background = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        Heading(pageTitle = title)
        content()
    }
}