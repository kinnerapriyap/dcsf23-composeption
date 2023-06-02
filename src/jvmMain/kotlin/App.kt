
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.dp
import common.Menu
import slides.AboutMeSlide
import slides.AgendaSlide
import slides.SummarySlide
import slides.ThankYouSlide
import slides.TitleSlide
import slides.content.ctoc.ContentToContentSlide
import slides.content.dialog.DialogSlideToShow
import slides.content.drawer.DrawerSlide
import slides.content.listdetail.ListDetailSlide


private const val ANIMATION_TIME_SLIDE = 3000

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App(
    screen: Screen,
    handleNavigation: (NavEvent) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = screen.getBackground(),
        contentColor = screen.getContentColor(),
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Menu("ic_menu.png") { handleNavigation(NavEvent.OnMenuClicked) }
                AnimatedContent(
                    targetState = screen,
                    transitionSpec = {
                        when (targetState) {
                            is Screen.Agenda -> slideInHorizontally(animationSpec = tween(ANIMATION_TIME_SLIDE)) { width -> width } +
                                    fadeIn(animationSpec = tween(ANIMATION_TIME_SLIDE)) with
                                    scaleOut(
                                        animationSpec = tween(ANIMATION_TIME_SLIDE),
                                        transformOrigin = TransformOrigin(1f, 0f)
                                    ) +
                                    fadeOut(animationSpec = tween(ANIMATION_TIME_SLIDE))

                            else ->
                                slideInVertically(animationSpec = tween(ANIMATION_TIME_SLIDE)) { height -> height } +
                                        fadeIn(animationSpec = tween(ANIMATION_TIME_SLIDE)) with
                                        slideOutVertically(animationSpec = tween(ANIMATION_TIME_SLIDE)) { height -> -height } +
                                        fadeOut(animationSpec = tween(ANIMATION_TIME_SLIDE))
                        }
                    }
                ) { currentScreen ->
                    Box(modifier = Modifier.padding(40.dp)) {
                        when (currentScreen) {
                            Screen.Title -> TitleSlide()
                            Screen.AboutMe -> AboutMeSlide(name = author)
                            Screen.Dialog -> DialogSlideToShow()
                            Screen.Drawer -> DrawerSlide()
                            Screen.ContentToContent -> ContentToContentSlide()
                            Screen.ListDetail -> ListDetailSlide()
                            Screen.Summary -> SummarySlide()
                            Screen.ThankYou -> ThankYouSlide()
                            Screen.Agenda -> AgendaSlide {
                                handleNavigation(NavEvent.OnMenuItemClicked(it))
                            }
                        }
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