package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.Plus
import common.RightArrow
import listDetailSlideTitle
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.ListDetailSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(listDetailSlideTitle) {
        Row(
            modifier = Modifier.padding(top = 120.dp).fillMaxWidth(),
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