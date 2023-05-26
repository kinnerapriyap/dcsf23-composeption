package slides

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import common.Slide
import nextButtonText

@Composable
@Preview
fun TitleSlide(
    title: String,
    subTitle: String,
    nextImagePath: String,
    modifier: Modifier = Modifier,
    onNextClicked: () -> Unit,
) {
    Slide(
        modifier = modifier,
        background = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = subTitle,
                style = MaterialTheme.typography.h3,
            )
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .size(200.dp)
                .padding(40.dp)
                .clickable { onNextClicked() },
            painter = painterResource(nextImagePath),
            contentDescription = nextButtonText,
        )
    }
}