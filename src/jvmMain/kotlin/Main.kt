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
import slides.ContentSlide
import slides.MenuSlide
import slides.TitleSlide
import theme.DroidconSFTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App() {
    var screenState by remember { mutableStateOf<Screen>(Screen.Title) }
    fun handleNavigation(): (NavEvent) -> Unit = { navEvent ->
        screenState = when (navEvent) {
            NavEvent.onBackClicked -> onBackClicked()
            NavEvent.onMenuClicked -> onMenuClicked()
            NavEvent.onNextClicked -> onNextClicked(screenState)
        }
    }
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
                    handleNavigation = handleNavigation()
                )

            Screen.AboutMe ->
                AboutMeSlide(
                    name = author,
                    handleNavigation = handleNavigation()
                )

            Screen.Agenda ->
                ContentSlide(
                    handleNavigation = handleNavigation()
                )

            Screen.Menu ->
                MenuSlide(
                    handleNavigation = handleNavigation()
                )
        }
    }
}

fun onMenuClicked() = Screen.Menu
fun onBackClicked() = Screen.Menu

fun onNextClicked(screen: Screen): Screen =
    when (screen) {
        Screen.Title -> Screen.AboutMe
        Screen.AboutMe -> Screen.Agenda
        Screen.Agenda -> Screen.Menu
        Screen.Menu -> screen
    }

sealed interface NavEvent {
    object onBackClicked : NavEvent
    object onNextClicked : NavEvent
    object onMenuClicked : NavEvent
}

fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = title,
        resizable = false,
    ) {
        DroidconSFTheme(
            darkMode = false,
            windowSize = state.size
        ) {
            App()
        }
    }
}
