import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.Menu
import slides.AboutMeSlide
import slides.AgendaSlide
import slides.MenuSlide
import slides.TitleSlide
import utils.NoRippleInteractionSource

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App(
    screen: Screen,
    handleNavigation: (NavEvent) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { NoRippleInteractionSource() },
                indication = LocalIndication.current,
                onClick = { handleNavigation(NavEvent.OnNextClicked) }
            ),
        color = screen.getBackground(),
        contentColor = screen.getContentColor(),
        content = {
            Box(modifier = Modifier.padding(40.dp)) {
                Menu("ic_menu.png") { handleNavigation(NavEvent.OnMenuClicked) }
                AnimatedContent(
                    targetState = screen,
                    transitionSpec = {
                        slideInVertically { height -> height } + fadeIn() with
                                slideOutVertically { height -> -height } + fadeOut()
                    }
                ) { currentScreen ->
                    when (currentScreen) {
                        Screen.Title -> TitleSlide(title = title, subTitle = author)
                        Screen.AboutMe -> AboutMeSlide(name = author)
                        Screen.Agenda -> AgendaSlide()
                        Screen.Menu -> MenuSlide()
                    }
                }
                // pageNumber?.let { PageCount(it) }
            }
        }
    )
}

@Composable
fun Screen.getBackground() =
    when (this) {
        Screen.Title -> MaterialTheme.colors.primary
        Screen.AboutMe -> MaterialTheme.colors.secondary
        else -> MaterialTheme.colors.surface
    }

@Composable
fun Screen.getContentColor() =
    when (this) {
        Screen.Title -> MaterialTheme.colors.onPrimary
        Screen.AboutMe -> MaterialTheme.colors.onSecondary
        else -> MaterialTheme.colors.onSurface
    }