package presentation.navigation

sealed class BottomNavigation(
    val route: String,
    val title: String,
) {
    data object Home : BottomNavigation(
        route = "Home",
        title = "Home",
    )
}
