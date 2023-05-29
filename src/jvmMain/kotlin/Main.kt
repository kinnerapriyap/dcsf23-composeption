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
import slides.AgendaSlide
import slides.MenuSlide
import slides.TitleSlide
import theme.DroidconSFTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App() {
    var screenState by remember { mutableStateOf<List<Screen>>(listOf(Screen.Title)) }
    fun handleNavigation(): (NavEvent) -> Unit = { navEvent ->
        screenState = screenState.toMutableList().apply {
            when (navEvent) {
                NavEvent.onBackClicked -> onBackClicked()
                NavEvent.onMenuClicked -> onMenuClicked()
                NavEvent.onNextClicked -> onNextClicked(screenState)
            }?.let { add(it) }
        }
    }
    AnimatedContent(
        targetState = screenState,
        transitionSpec = {
            slideInVertically { height -> height } + fadeIn() with
                    slideOutVertically { height -> -height } + fadeOut()
        }
    ) {
        when (it.last()) {
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
                AgendaSlide(
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

fun onNextClicked(screenState: List<Screen>): Screen? =
    when (screenState.last()) {
        Screen.Title -> Screen.AboutMe
        Screen.AboutMe -> Screen.Agenda
        Screen.Agenda -> Screen.Menu
        Screen.Menu -> screenState.getOrNull(screenState.size - 2)
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
