
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
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.dp
import common.Menu
import slides.other.AboutMeSlide
import slides.other.AgendaSlide
import slides.other.SummarySlide
import slides.other.ThankYouSlide
import slides.other.TitleSlide
import slides.content.ctoc.ContentToContentSlide
import slides.content.dialog.utils.DialogSlideToShow
import slides.content.drawer.DrawerSlide
import slides.content.listdetail.utils.ListDetailSlide


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
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Menu(modifier = Modifier.padding(40.dp)) { handleNavigation(NavEvent.OnMenuClicked) }
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
                            Screen.AboutMe -> AboutMeSlide()
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