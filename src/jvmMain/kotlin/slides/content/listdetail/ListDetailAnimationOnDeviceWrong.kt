package slides.content.listdetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import backButtonText
import common.AndroidDeviceLazyColumn

@Composable
@Preview
fun ListDetailAnimationOnDeviceWrong(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    elements: List<Pair<String, String>> = (0..10).map { "Title $it" to "Subtitle $it" }
) {
    var selected: Int? by remember { mutableStateOf(null) }
    AndroidDeviceLazyColumn(
        width = width,
        ratio = ratio,
        verticalSpacing = 12.dp
    ) {
        item {
            IconButton(modifier = Modifier.size(48.dp), onClick = { selected = null }) {
                Image(painter = painterResource("ic_back.png"), contentDescription = backButtonText)
            }
        }
        itemsIndexed(elements) { index, (title, subtitle) ->
            AnimatedVisibility(visible = selected == null || selected == index) {
                ListItem(
                    modifier = Modifier,
                    title = title,
                    subtitle = subtitle
                ) { selected = index }
            }
        }
        item {
            AnimatedVisibility(visible = selected != null) {
                selected?.let { DetailItem() }
            }
        }
    }
}