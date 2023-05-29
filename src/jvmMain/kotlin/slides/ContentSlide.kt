package slides

import NavEvent
import agendaScreenTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.Heading
import common.Slide

@Composable
@Preview
fun ContentSlide(
    handleNavigation: (NavEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Slide(
        onMenuClicked = { handleNavigation(NavEvent.onMenuClicked) },
        onNextClicked = { handleNavigation(NavEvent.onNextClicked) },
        modifier = modifier,
        background = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        Heading(pageTitle = agendaScreenTitle)
    }
}