package slides.content.listdetail.utils

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import common.AndroidDeviceLazyColumn
import slides.content.listdetail.DetailItem

@Composable
@Preview
fun DetailOnDevice(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    element: Pair<String, String> = "Title 2" to "Subtitle 2"
) {
    AndroidDeviceLazyColumn(width = width, ratio = ratio) {
        item {
            ListItem(title = element.first, subtitle = element.second, enableClick = false) {}
        }
        item {
            DetailItem()
        }
    }
}