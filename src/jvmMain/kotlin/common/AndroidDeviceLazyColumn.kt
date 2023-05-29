package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@Preview
fun AndroidDeviceLazyColumn(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    contentPadding: PaddingValues = PaddingValues(12.dp),
    verticalSpacing: Dp = 12.dp,
    content: LazyListScope.() -> Unit,
) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing),
        modifier = modifier
            .size(width, width * ratio)
            .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp))
            .draggable(
                orientation = Orientation.Vertical,
                state = rememberDraggableState { delta -> coroutineScope.launch { scrollState.scrollBy(-delta) } },
            ),
        contentPadding = contentPadding
    ) {
        content()
    }
}