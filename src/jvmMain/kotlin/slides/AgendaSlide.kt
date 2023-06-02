package slides

import Screen
import agendaSlideTitle
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.ContentSlide
import contentToContentSlideTitle
import dialogSlideTitle
import drawerSlideTitle
import listDetailSlideTitle
import slides.content.ctoc.Content1ToContent2InfiniteAnimation
import slides.content.dialog.DialogAnimationOnDevice
import slides.content.drawer.NavDrawerInfiniteAnimationOnDevice
import slides.content.listdetail.ListDetailInfiniteAnimationOnDevice

@Composable
@Preview
fun AgendaSlide(
    modifier: Modifier = Modifier,
    onMenuItemClicked: (Screen) -> Unit,
) {
    ContentSlide(agendaSlideTitle) {
        Row(
            modifier = modifier.fillMaxWidth(),
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
                DialogAnimationOnDevice()
            }
            Column(verticalArrangement = Arrangement.Center) {
                Button(onClick = { onMenuItemClicked(Screen.ContentToContent) }) { Text(contentToContentSlideTitle) }
                Content1ToContent2InfiniteAnimation()
            }
        }
    }
}