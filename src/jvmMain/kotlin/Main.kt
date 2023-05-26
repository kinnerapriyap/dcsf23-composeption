import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import slides.AboutMeSlide
import slides.TitleSlide
import theme.DroidconSFTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App() {
    var screenState by remember { mutableStateOf<Screen>(Screen.Title) }
    DroidconSFTheme(darkMode = false) {
        AnimatedContent(
            targetState = screenState,
            transitionSpec = {
                slideInVertically { height -> height } + fadeIn() with
                        slideOutVertically { height -> -height } + fadeOut()
            }
        ) {
            when (it) {
                Screen.Title ->
                    TitleSlide(
                        title = title,
                        subTitle = author,
                        nextImagePath = "ic_next.png",
                    ) { screenState = Screen.AboutMe }

                Screen.AboutMe ->
                    AboutMeSlide(name = author)

                Screen.Agenda -> TODO()
            }
        }
    }
}

fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = title,
        resizable = false,
    ) {
        App()
    }
}
