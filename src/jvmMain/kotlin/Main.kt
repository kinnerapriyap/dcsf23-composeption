import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import theme.DroidconSFTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)
    var screenState by remember { mutableStateOf<List<Screen>>(listOf(Screen.Title)) }
    fun handleNavigation(): (NavEvent) -> Unit = { navEvent ->
        screenState = screenState.toMutableList().apply {
            when (navEvent) {
                is NavEvent.OnMenuItemClicked -> navEvent.screen
                NavEvent.OnMenuClicked -> {
                    indexOf(Screen.AboutMe).let { if (it != -1) removeAll(subList(it + 1, lastIndex + 1)) }
                    Screen.Menu
                }

                NavEvent.OnNextClicked -> onNextClicked(this)
                NavEvent.OnBackClicked -> {
                    if (size > 1) removeLastOrNull()
                    lastOrNull()
                }
            }?.let { if (it != last()) add(it) }
        }
    }
    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = title,
        resizable = false,
        onKeyEvent = {
            if (it.key == Key.DirectionRight && it.type == KeyEventType.KeyUp) {
                handleNavigation().invoke(NavEvent.OnNextClicked)
                true
            } else if (it.key == Key.DirectionLeft && it.type == KeyEventType.KeyUp) {
                handleNavigation().invoke(NavEvent.OnBackClicked)
                true
            } else false
        }
    ) {
        DroidconSFTheme(darkMode = false, windowSize = state.size) {
            App(screenState.last(), handleNavigation())
        }
    }
}
