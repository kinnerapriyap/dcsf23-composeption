package slides.content.ctoc

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.AndroidDeviceSurface
import cupcakeIpsum

@Composable
@Preview
fun Content2() {
    AndroidDeviceSurface {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = cupcakeIpsum
            )
        }
    }
}