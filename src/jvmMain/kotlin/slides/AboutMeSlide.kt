package slides

import aboutMeScreenTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.Heading
import common.Slide

@Composable
@Preview
fun AboutMeSlide(
    name: String,
    modifier: Modifier = Modifier
) {
    Slide {
        Column(
            modifier = Modifier.fillMaxSize().padding(40.dp),
        ) {
            Heading(pageTitle = aboutMeScreenTitle)
        }
    }
}