package presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface HomeNavigation {
    @Serializable
    data object Home : HomeNavigation
}
