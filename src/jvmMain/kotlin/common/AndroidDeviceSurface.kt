package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun AndroidDeviceSurface(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier.size(width, width * ratio),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(4.dp, MaterialTheme.colors.primary)
    ) { content() }
}