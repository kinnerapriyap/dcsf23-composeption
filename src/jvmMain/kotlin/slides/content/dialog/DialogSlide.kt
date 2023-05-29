package slides.content.dialog

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dialogSlideTitle
import showDialogText
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.DialogSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(dialogSlideTitle) {
        var shouldAnimate by remember { mutableStateOf(false) }
        var showDialog by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxSize()) {
            if (showDialog) DialogItem { showDialog = false }
            Checkbox(
                modifier = Modifier.align(Alignment.BottomEnd).padding(50.dp),
                checked = shouldAnimate,
                onCheckedChange = { shouldAnimate = it }
            )
            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {
                    showDialog = true
                }
            ) {
                Text(text = showDialogText)
            }
        }
    }
}