package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import listDetailSlideTitle
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.ListDetailSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(listDetailSlideTitle) {
        Row(modifier = Modifier.padding(top = 150.dp, start = 150.dp)) {
            ListOnDevice()
            Spacer(modifier = Modifier.width(100.dp))
            DetailOnDevice()
            Spacer(modifier = Modifier.width(100.dp))
            ListDetailAnimationOnDevice()
        }
    }
}