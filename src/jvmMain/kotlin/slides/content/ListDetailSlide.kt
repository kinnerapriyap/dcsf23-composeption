package slides.content

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import listDetailSlideTitle

@Composable
@Preview
fun BoxScope.ListDetailSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(listDetailSlideTitle) {

    }
}