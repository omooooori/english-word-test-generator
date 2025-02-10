package presentation.ui.main.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.koinInject
import presentation.navigation.HomeNavigation
import presentation.ui.main.home.viewmodel.HomeViewModel

@Composable
fun HomeNav() {
    val navigator = rememberNavController()
    NavHost(
        startDestination = HomeNavigation.Home,
        navController = navigator,
        modifier = Modifier.fillMaxSize(),
    ) {
        composable<HomeNavigation.Home> {
            val viewModel: HomeViewModel = koinInject()
            HomeScreen(
                errors = viewModel.errors,
                state = viewModel.state.value,
                events = viewModel::onTriggerEvent,
            )
        }
    }
}
