package slides

import aboutMeInfo
import aboutMeScreenTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import common.Heading

@Composable
@Preview
fun AboutMeSlide(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Heading(pageTitle = aboutMeScreenTitle)
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            modifier = Modifier.weight(1f).fillMaxSize(),
            text = aboutMeInfo,
            lineHeight = TextUnit(4f, TextUnitType.Em),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
    }
}