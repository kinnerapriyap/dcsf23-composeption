package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import common.AndroidDeviceLazyColumn
import common.Back
import slides.content.listdetail.utils.ListItem

@Composable
@Preview
fun CurrentListDetailOnDevice(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    elements: List<Pair<String, String>> = (0..10).map { "Title $it" to "Subtitle $it" }
) {
    var selected: Int? by remember { mutableStateOf(null) }
    AndroidDeviceLazyColumn(
        width = width,
        ratio = ratio,
        verticalSpacing = if (selected == null) 12.dp else 0.dp
    ) {
        item {
            IconButton(modifier = Modifier.size(48.dp), onClick = { selected = null }) { Back() }
        }
        itemsIndexed(elements) { index, (title, subtitle) ->
            // Items List
            if (selected == null || selected == index) {
                ListItem(
                    modifier = Modifier,
                    title = title,
                    subtitle = subtitle
                ) { selected = index }
            }
        }
        item {
            // Detail Item
            selected?.let { DetailItem() }
        }
    }
}