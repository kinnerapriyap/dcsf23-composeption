package slides.content.dialog

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import common.ContentSlide
import dialogSlideTitle
import showDialogText

@Composable
@Preview
fun DialogSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(dialogSlideTitle) {
        var showDialog by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxSize()) {
            if (showDialog) DialogItem { showDialog = false }
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