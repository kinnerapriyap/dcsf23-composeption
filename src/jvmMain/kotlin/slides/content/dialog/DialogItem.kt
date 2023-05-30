package slides.content.dialog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.rememberDialogState
import cupcakeIpsumShort
import dialogTitle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun DialogItem(
    width: Dp = 300.dp,
    ratio: Float = 16f / 9f,
    onDismiss: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    var animation by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        launch {
            delay(300)
            animation = true
        }
    }
    val state = rememberDialogState(width = width, height = width * ratio)
    Dialog(
        state = state,
        onCloseRequest = {
            scope.launch {
                animation = false
                delay(1000)
                onDismiss()
            }
        },
        title = dialogTitle,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = animation,
                enter = scaleIn(animationSpec = tween(1000)),
                exit = scaleOut(animationSpec = tween(1000)),
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        modifier = Modifier.align(Alignment.Center).background(MaterialTheme.colors.background)
                            .padding(32.dp),
                        text = cupcakeIpsumShort,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}