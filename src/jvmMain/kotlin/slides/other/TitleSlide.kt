package slides.other

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import author
import presentationTitle

@Composable
@Preview
fun TitleSlide(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(40.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = presentationTitle,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = author,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primary
        )
    }
}