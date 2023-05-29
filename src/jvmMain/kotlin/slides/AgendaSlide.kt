package slides

import agendaScreenTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.AgendaSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(agendaScreenTitle) {

    }
}