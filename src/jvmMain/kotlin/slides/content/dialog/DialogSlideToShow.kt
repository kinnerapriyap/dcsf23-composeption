package slides.content.dialog

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.ContentSlide
import dialogSlideTitle

@Composable
@Preview
fun DialogSlideToShow(
    modifier: Modifier = Modifier
) {
    ContentSlide(dialogSlideTitle) {
        DialogAnimationOnDevice()
    }
}