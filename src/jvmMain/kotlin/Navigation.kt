sealed interface NavEvent {
    object OnBackClicked : NavEvent
    object OnNextClicked : NavEvent
    object OnMenuClicked : NavEvent
    data class OnMenuItemClicked(val screen: Screen) : NavEvent
}

fun onNextClicked(screenState: List<Screen>): Screen =
    when (screenState.last()) {
        Screen.Title -> Screen.AboutMe
        Screen.AboutMe -> Screen.Menu
        Screen.ListDetail -> Screen.Menu
        Screen.Dialog -> Screen.Menu
        Screen.Drawer -> Screen.Menu
        Screen.Menu -> screenState.last()
    }