package common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import utils.NoRippleInteractionSource

@Composable
@Preview
fun Slide(
    onMenuClicked: () -> Unit,
    onNextClicked: () -> Unit,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.background,
    contentColor: Color = MaterialTheme.colors.onBackground,
    menuImagePath: String = "ic_menu.png",
    pageNumber: Int? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { NoRippleInteractionSource() },
                indication = LocalIndication.current,
                onClick = { onNextClicked() }
            ),
        color = background,
        contentColor = contentColor,
        content = {
            Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Menu(menuImagePath) { onMenuClicked() }
                content()
                pageNumber?.let { PageCount(it) }
            }
        }
    )
}