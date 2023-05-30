package slides.content.ctoc

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import common.AndroidDeviceSurface
import cupcakeIpsum
import cupcakeIpsumShort
import lessButtonText
import moreButtonText

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun Content1ToContent2Animation() {
    var expanded by remember { mutableStateOf(false) }
    AndroidDeviceSurface {
        AnimatedContent(targetState = expanded) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (it) cupcakeIpsum else cupcakeIpsumShort,
                    textAlign = TextAlign.Center
                )
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally).animateContentSize(),
                    onClick = { expanded = !expanded }
                ) {
                    Text(text = if (it) lessButtonText else moreButtonText)
                }
            }
        }
    }
}