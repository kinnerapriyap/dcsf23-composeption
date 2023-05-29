package slides

import NavEvent
import agendaScreenTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@Preview
fun AgendaSlide(
    handleNavigation: (NavEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    ContentSlide(agendaScreenTitle, handleNavigation, modifier) {

    }
}