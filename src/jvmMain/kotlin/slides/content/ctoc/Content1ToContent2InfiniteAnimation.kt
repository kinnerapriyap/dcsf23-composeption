package slides.content.ctoc

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import cupcakeIpsumShort

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun Content1ToContent2InfiniteAnimation() {
    val transition = rememberInfiniteTransition()
    val expanded = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    AndroidDeviceSurface {
        AnimatedContent(targetState = expanded.value > 0.5f) {
            Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = if (it) cupcakeIpsum else cupcakeIpsumShort
                )
            }
        }
    }
}