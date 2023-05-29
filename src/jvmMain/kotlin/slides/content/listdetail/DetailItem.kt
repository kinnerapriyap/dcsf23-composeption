package slides.content.listdetail

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cupcakeIpsum

@Composable
@Preview
fun DetailItem() {
    Text(
        modifier = Modifier.padding(16.dp),
        text = cupcakeIpsum,
        style = MaterialTheme.typography.body1,
    )
}