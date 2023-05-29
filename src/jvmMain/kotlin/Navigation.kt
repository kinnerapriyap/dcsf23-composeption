sealed interface NavEvent {
    object OnBackClicked : NavEvent
    object OnNextClicked : NavEvent
    object OnMenuClicked : NavEvent
}

fun onNextClicked(screenState: List<Screen>): Screen =
    when (screenState.last()) {
        Screen.Title -> Screen.AboutMe
        Screen.AboutMe -> Screen.Agenda
        Screen.Agenda -> Screen.Menu
        Screen.Menu -> screenState.last()
    }