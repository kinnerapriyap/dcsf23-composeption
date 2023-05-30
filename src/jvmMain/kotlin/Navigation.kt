sealed interface NavEvent {
    object OnBackClicked : NavEvent
    object OnNextClicked : NavEvent
    object OnMenuClicked : NavEvent
    data class OnMenuItemClicked(val screen: Screen) : NavEvent
}

fun onNextClicked(screenState: List<Screen>): Screen =
    when (screenState.last()) {
        Screen.Title -> Screen.AboutMe
        Screen.AboutMe -> Screen.Agenda
        Screen.ListDetail -> Screen.Agenda
        Screen.Dialog -> Screen.Agenda
        Screen.ContentToContent -> Screen.Agenda
        Screen.Drawer -> Screen.Agenda
        Screen.Agenda -> screenState.last()
    }