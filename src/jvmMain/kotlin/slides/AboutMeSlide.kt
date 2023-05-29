package slides

import aboutMeInfo
import aboutMeScreenTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import common.Heading

@Composable
@Preview
fun BoxScope.AboutMeSlide(
    name: String,
) {
    Heading(pageTitle = aboutMeScreenTitle)
    Text(
        modifier = Modifier.align(Alignment.Center),
        text = aboutMeInfo,
        lineHeight = TextUnit(4f, TextUnitType.Em),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5
    )
}