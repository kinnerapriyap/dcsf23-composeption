package slides

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import menuText

@Composable
@Preview
fun BoxScope.MenuSlide(
    modifier: Modifier = Modifier,
) {
    ContentSlide(menuText) {

    }
}