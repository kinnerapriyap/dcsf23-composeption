package slides.content.drawer

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import common.AndroidDeviceSurface
import common.Back
import common.Menu

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun NavDrawerOnDevice() {
    AndroidDeviceSurface {
        var expanded by remember { mutableStateOf(false) }
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                slideIntoContainer(
                    animationSpec = tween(150, 150),
                    towards = AnimatedContentScope.SlideDirection.End
                ) with slideOutOfContainer(
                    animationSpec = tween(150),
                    towards = AnimatedContentScope.SlideDirection.Start
                )
            }
        ) { target ->
            Box(modifier = Modifier.fillMaxSize()) {
                // Navigation Drawer Content
                if (target) {
                    Surface(
                        modifier = Modifier.width(200.dp).fillMaxHeight(),
                        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                        border = BorderStroke(2.dp, MaterialTheme.colors.secondary),
                        elevation = 4.dp
                    ) {}
                }

                // Navigation / Back buttons
                IconButton(
                    modifier = Modifier.padding(12.dp).size(48.dp).align(Alignment.TopStart),
                    onClick = { expanded = !expanded }
                ) {
                    if (target) Back()
                    else Menu(
                        modifier = Modifier.padding(12.dp),
                        size = with(LocalDensity.current) { 24.dp.toPx() }
                    ) { expanded = !expanded }
                }
            }
        }
    }
}