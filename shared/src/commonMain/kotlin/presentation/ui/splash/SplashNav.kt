package presentation.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import presentation.navigation.SplashNavigation

@Composable
internal fun SplashNav(navigateToMain: () -> Unit) {
    val navigator = rememberNavController()
    LaunchedEffect(Unit) {
        delay(3000L)
        navigateToMain()
    }

    NavHost(
        startDestination = SplashNavigation.Splash,
        navController = navigator,
        modifier = Modifier.fillMaxSize(),
    ) {
        composable<SplashNavigation.Splash> {
            SplashScreen()
        }
    }
}
