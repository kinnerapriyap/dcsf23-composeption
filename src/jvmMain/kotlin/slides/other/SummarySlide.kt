package slides.other

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import common.ContentSlide
import contentToContentDescription
import contentToContentSlideTitle
import dialogDescription
import dialogSlideTitle
import drawerDescription
import drawerSlideTitle
import listDetailDescription
import listDetailSlideTitle
import summarySlideSlideTitle

@Composable
@Preview
fun SummarySlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(summarySlideSlideTitle) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SummaryPoint(1, listDetailSlideTitle, listDetailDescription, Modifier.weight(1f))
                SummaryPoint(2, drawerSlideTitle, drawerDescription, Modifier.weight(1f))
            }
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SummaryPoint(3, dialogSlideTitle, dialogDescription, Modifier.weight(1f))
                SummaryPoint(4, contentToContentSlideTitle, contentToContentDescription, Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun SummaryPoint(
    number: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number.toString(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = title.uppercase(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
    }
}