package slides

import Screen
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dialogSlideTitle
import drawerSlideTitle
import listDetailSlideTitle
import menuText
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.MenuSlide(
    modifier: Modifier = Modifier,
    onMenuItemClicked: (Screen) -> Unit,
) {
    ContentSlide(menuText) {
        Column {
            Button(onClick = { onMenuItemClicked(Screen.ListDetail) }) {
                Text(listDetailSlideTitle)
            }
            Button(onClick = { onMenuItemClicked(Screen.Drawer) }) {
                Text(drawerSlideTitle)
            }
            Button(onClick = { onMenuItemClicked(Screen.Dialog) }) {
                Text(dialogSlideTitle)
            }
        }
    }
}