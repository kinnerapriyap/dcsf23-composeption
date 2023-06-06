package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
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
fun RightArrow(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxHeight()) {
        val color = MaterialTheme.colors.primary
        val size = with(LocalDensity.current) { 24.dp.toPx() }
        Canvas(
            modifier = modifier.size(48.dp).align(Alignment.Center)
        ) {
            drawLine(
                color = color,
                start = Offset(0f, size / 2),
                end = Offset(size, size / 2),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = color,
                start = Offset(size / 2, 0f),
                end = Offset(size, size / 2),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = color,
                start = Offset(size, size / 2),
                end = Offset(size / 2, size),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )
        }
    }
}