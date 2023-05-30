package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import agendaSlideTitle
import androidx.compose.foundation.layout.padding

@Composable
@Preview
fun BoxScope.Menu(
    menuImagePath: String,
    modifier: Modifier = Modifier,
    onMenuClicked: () -> Unit,
) {
    Image(
        modifier = modifier.padding(40.dp).align(Alignment.TopEnd).size(48.dp).clickable { onMenuClicked() },
        painter = painterResource(menuImagePath),
        contentDescription = agendaSlideTitle,
    )
}