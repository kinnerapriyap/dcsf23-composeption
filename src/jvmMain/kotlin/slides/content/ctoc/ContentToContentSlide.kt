package slides.content.ctoc

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import contentToContentSlideTitle
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.ContentToContentSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(contentToContentSlideTitle) {
        Row(modifier = Modifier.padding(top = 150.dp, start = 150.dp)) {
            Content1()
            Spacer(modifier = Modifier.width(100.dp))
            Content2()
            Spacer(modifier = Modifier.width(100.dp))
            Content1ToContent2InfiniteAnimation()
        }

    }
}