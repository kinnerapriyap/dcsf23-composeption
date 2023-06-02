package slides.content.drawer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.ContentSlide
import drawerSlideTitle

@Composable
@Preview
fun DrawerSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(drawerSlideTitle) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavDrawerOnDevice()
            BottomSheetOnDevice()
        }
    }
}