package slides.content.ctoc

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
import contentToContentSlideTitle
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.ContentToContentSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(contentToContentSlideTitle) {
        Row(
            modifier = Modifier.padding(top = 120.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Content1()
            Plus()
            Content2()
            RightArrow()
            Content1ToContent2InfiniteAnimation()
        }

    }
}