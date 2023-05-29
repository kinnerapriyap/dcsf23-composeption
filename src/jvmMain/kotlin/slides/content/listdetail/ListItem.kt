package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun ListItem(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    enableClick: Boolean = true,
    onClick: (() -> Unit)
) {
    Surface(
        modifier = modifier.height(IntrinsicSize.Min),
        onClick = onClick,
        enabled = enableClick,
        shape = HoleShape(
            cornerRadius = with(LocalDensity.current) { 16.dp.toPx() },
            punchSize = with(LocalDensity.current) { 16.dp.toPx() },
            punchDistance = with(LocalDensity.current) { 16.dp.toPx() },
        ),
        color = MaterialTheme.colors.secondary,
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSecondary,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSecondary,
            )
        }
    }
}