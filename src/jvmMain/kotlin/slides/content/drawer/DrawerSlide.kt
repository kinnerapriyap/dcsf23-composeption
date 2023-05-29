package slides.content.drawer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import drawerSlideTitle
import slides.content.ContentSlide

@Composable
@Preview
fun BoxScope.DrawerSlide(
    modifier: Modifier = Modifier
) {
    ContentSlide(drawerSlideTitle) {
        Row(modifier = Modifier.padding(top = 150.dp, start = 150.dp)) {
            NavDrawerOnDevice()
            Spacer(modifier = Modifier.width(100.dp))
            BottomSheetOnDevice()
        }
    }
}