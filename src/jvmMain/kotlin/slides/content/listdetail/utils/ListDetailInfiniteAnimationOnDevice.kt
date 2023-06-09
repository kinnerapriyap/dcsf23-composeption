package slides.content.listdetail.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import common.AndroidDeviceLazyColumn
import common.Back
import slides.content.listdetail.DetailItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun ListDetailInfiniteAnimationOnDevice() {
    val transition = rememberInfiniteTransition()
    val selectedAnimationValue = transition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val elements = (0..10).map { "Title $it" to "Subtitle $it" }
    AndroidDeviceLazyColumn(
        width = 300.dp,
        ratio = 16f / 9f,
        verticalSpacing = if (selectedAnimationValue.value.toInt() % 2 == 0) 12.dp else 0.dp
    ) {
        item {
            IconButton(onClick = { }) { Back() }
        }
        itemsIndexed(elements) { index, (title, subtitle) ->
            AnimatedVisibility(visible = selectedAnimationValue.value.toInt() % 2 == 0 || selectedAnimationValue.value.toInt() == index) {
                ListItem(
                    title = title,
                    subtitle = subtitle
                ) { }
            }
        }
        item {
            AnimatedVisibility(visible = selectedAnimationValue.value.toInt() % 2 != 0) {
                selectedAnimationValue.value.toInt().let { DetailItem() }
            }
        }
    }
}