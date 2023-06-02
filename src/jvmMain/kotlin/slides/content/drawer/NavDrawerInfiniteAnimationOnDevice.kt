package slides.content.drawer

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import common.AndroidDeviceSurface

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun NavDrawerInfiniteAnimationOnDevice() {
    val transition = rememberInfiniteTransition()
    val expanded = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    AndroidDeviceSurface {
        AnimatedContent(
            targetState = expanded.value > 0.5f,
            transitionSpec = {
                slideIntoContainer(
                    animationSpec = tween(300, 300),
                    towards = AnimatedContentScope.SlideDirection.End
                ) with slideOutOfContainer(
                    animationSpec = tween(300),
                    towards = AnimatedContentScope.SlideDirection.Start
                )
            }
        ) { target ->
            Box(modifier = Modifier.fillMaxSize()) {
                if (target) {
                    Surface(
                        modifier = Modifier.width(200.dp).fillMaxHeight(),
                        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                        border = BorderStroke(2.dp, MaterialTheme.colors.secondary),
                        elevation = 4.dp
                    ) {}
                }
                IconButton(
                    modifier = Modifier.padding(12.dp).size(48.dp).align(Alignment.TopStart),
                    onClick = { }
                ) {
                    Image(
                        painter = painterResource(if (target) "ic_back.png" else "ic_crown.png"),
                        contentDescription = null
                    )
                }
            }
        }
    }
}