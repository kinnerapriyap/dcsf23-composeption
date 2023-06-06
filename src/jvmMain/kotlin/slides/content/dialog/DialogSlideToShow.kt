package slides.content.dialog

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import animationDialog
import common.ContentSlide
import dialogSlideTitle
import noAnimationDialog

@Composable
@Preview
fun DialogSlideToShow(
    modifier: Modifier = Modifier
) {
    ContentSlide(dialogSlideTitle) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = noAnimationDialog,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = animationDialog,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DialogNoAnimationOnDevice()
                DialogAnimationOnDevice()
            }
        }
    }
}