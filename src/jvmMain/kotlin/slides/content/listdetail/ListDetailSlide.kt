package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.ContentSlide
import common.Plus
import common.RightArrow
import listDetailSlideTitle

@Composable
@Preview
fun ListDetailSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(listDetailSlideTitle) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ListOnDevice()
            Plus()
            DetailOnDevice()
            RightArrow()
            ListDetailAnimationOnDevice()
        }
    }
}