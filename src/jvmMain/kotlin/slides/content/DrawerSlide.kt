package slides.content

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import drawerSlideTitle

@Composable
@Preview
fun BoxScope.DrawerSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(drawerSlideTitle) {

    }
}