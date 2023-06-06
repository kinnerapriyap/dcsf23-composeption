package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun BoxScope.Menu(
    menuImagePath: String,
    modifier: Modifier = Modifier,
    onMenuClicked: () -> Unit,
) {
    val color = MaterialTheme.colors.secondary
    val size = with(LocalDensity.current) { 40.dp.toPx() }
    Canvas(
        modifier = modifier
            .padding(40.dp)
            .align(Alignment.TopEnd)
            .size(48.dp)
            .clickable { onMenuClicked() }
    ) {
        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size, 0f),
            strokeWidth = 16f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = color,
            start = Offset(0f, size / 2),
            end = Offset(size, size / 2),
            strokeWidth = 16f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = color,
            start = Offset(0f, size),
            end = Offset(size, size),
            strokeWidth = 16f,
            cap = StrokeCap.Round
        )
    }
}