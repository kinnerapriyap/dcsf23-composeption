package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun Heading(
    pageTitle: String,
    topic: String? = null,
) {
    Column(modifier = Modifier.padding(40.dp)) {
        topic?.let {
            Text(
                text = topic,
                style = MaterialTheme.typography.subtitle1,
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        Text(
            text = pageTitle,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold
        )
    }
}