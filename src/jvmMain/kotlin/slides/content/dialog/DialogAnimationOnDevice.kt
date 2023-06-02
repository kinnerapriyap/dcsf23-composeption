package slides.content.dialog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import common.AndroidDeviceSurface
import cupcakeIpsumTiny

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun DialogAnimationOnDevice() {
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
        Box(
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = expanded.value > 0.5f,
                enter = fadeIn(animationSpec = tween(1000)),
                exit = fadeOut(animationSpec = tween(1000))
            ) {
                Box(modifier = Modifier.fillMaxSize().background(color = Color(0x55222222)).zIndex(-1f))
            }
            AnimatedVisibility(
                visible = expanded.value > 0.5f,
                enter = scaleIn(animationSpec = tween(1000)),
                exit = scaleOut(animationSpec = tween(1000)),
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize(align = Alignment.Center)
                        .padding(16.dp)
                        .align(Alignment.Center)
                        .background(MaterialTheme.colors.background)
                        .padding(32.dp),
                    text = cupcakeIpsumTiny,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}