package slides.content.listdetail.utils

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.ContentSlide
import common.Plus
import common.RightArrow
import listDetailSlideTitle
import slides.content.listdetail.CurrentListDetailOnDevice
import slides.content.listdetail.ListDetailAnimationOnDevice
import slides.content.listdetail.ListOnDevice

@Composable
@Preview
fun ListDetailSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(listDetailSlideTitle) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ListOnDevice()
            Spacer(modifier = Modifier.width(16.dp))
            Plus()
            DetailOnDevice()
            Spacer(modifier = Modifier.width(16.dp))
            RightArrow()
            CurrentListDetailOnDevice()
            Spacer(modifier = Modifier.width(16.dp))
            RightArrow()
            ListDetailAnimationOnDevice()
        }
    }
}