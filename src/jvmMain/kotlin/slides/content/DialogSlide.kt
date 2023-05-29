package slides.content

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dialogSlideTitle

@Composable
@Preview
fun BoxScope.DialogSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(dialogSlideTitle) {

    }
}