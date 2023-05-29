package slides

import NavEvent
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.Heading
import common.Slide
import menuText

@Composable
@Preview
fun MenuSlide(
    handleNavigation: (NavEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Slide(
        onMenuClicked = { handleNavigation(NavEvent.onMenuClicked) },
        onNextClicked = { handleNavigation(NavEvent.onNextClicked) },
        modifier = modifier,
    ) {
        Heading(pageTitle = menuText)
    }
}