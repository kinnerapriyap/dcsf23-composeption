package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import common.AndroidDeviceLazyColumn
import slides.content.listdetail.utils.ListItem

@Composable
@Preview
fun ListOnDevice(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    elements: List<Pair<String, String>> = (0..10).map { "Title $it" to "Subtitle $it" }
) {
    AndroidDeviceLazyColumn(width = width, ratio = ratio) {
        items(elements) { (title, subtitle) ->
            ListItem(title, subtitle) {}
        }
    }
}