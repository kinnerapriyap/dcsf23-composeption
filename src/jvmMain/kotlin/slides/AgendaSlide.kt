package slides

import Screen
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import common.AndroidDeviceSurface
import contentToContentSlideTitle
import dialogSlideTitle
import drawerSlideTitle
import listDetailSlideTitle
import agendaSlideTitle
import slides.content.ContentSlide
import slides.content.ctoc.Content1ToContent2InfiniteAnimation
import slides.content.drawer.NavDrawerInfiniteAnimationOnDevice
import slides.content.listdetail.ListDetailInfiniteAnimationOnDevice

@Composable
@Preview
fun BoxScope.AgendaSlide(
    modifier: Modifier = Modifier,
    onMenuItemClicked: (Screen) -> Unit,
) {
    ContentSlide(agendaSlideTitle) {
        Row(
            modifier = modifier.padding(top = 120.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Button(onClick = { onMenuItemClicked(Screen.ListDetail) }) { Text(listDetailSlideTitle) }
                ListDetailInfiniteAnimationOnDevice()
            }
            Column(verticalArrangement = Arrangement.Center) {
                Button(onClick = { onMenuItemClicked(Screen.Drawer) }) { Text(drawerSlideTitle) }
                NavDrawerInfiniteAnimationOnDevice()
            }
            Column(verticalArrangement = Arrangement.Center) {
                Button(onClick = { onMenuItemClicked(Screen.Dialog) }) { Text(dialogSlideTitle) }
                AndroidDeviceSurface {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource("dialog_screenshot.png"),
                        contentDescription = null
                    )
                }
            }
            Column(verticalArrangement = Arrangement.Center) {
                Button(onClick = { onMenuItemClicked(Screen.ContentToContent) }) { Text(contentToContentSlideTitle) }
                Content1ToContent2InfiniteAnimation()
            }
        }
    }
}