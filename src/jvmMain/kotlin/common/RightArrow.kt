package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun RightArrow() {
    Box(modifier = Modifier.fillMaxHeight()) {
        Image(
            modifier = Modifier.size(48.dp).align(Alignment.Center),
            painter = painterResource("ic_right.png"),
            contentDescription = null
        )
    }
}