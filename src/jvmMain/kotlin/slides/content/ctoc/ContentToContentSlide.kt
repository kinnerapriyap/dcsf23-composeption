package slides.content.ctoc

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.ContentSlide
import common.Plus
import common.RightArrow
import contentToContentSlideTitle

@Composable
@Preview
fun ContentToContentSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(contentToContentSlideTitle) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Content1()
            Plus()
            Content2()
            RightArrow()
            Content1ToContent2Animation()
        }

    }
}