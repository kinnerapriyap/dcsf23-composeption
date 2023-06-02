package slides

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import common.Heading
import contentToContentSlideTitle
import dialogSlideTitle
import drawerSlideTitle
import listDetailSlideTitle
import summarySlideSlideTitle

@Composable
@Preview
fun SummarySlide(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Heading(pageTitle = summarySlideSlideTitle)
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SummaryPoint(1, listDetailSlideTitle, "hahaha", Modifier.weight(1f))
            SummaryPoint(2, drawerSlideTitle, "hahaha", Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SummaryPoint(3, dialogSlideTitle, "hahaha", Modifier.weight(1f))
            SummaryPoint(4, contentToContentSlideTitle, "hahaha", Modifier.weight(1f))
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
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = title.uppercase(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1
        )
    }
}