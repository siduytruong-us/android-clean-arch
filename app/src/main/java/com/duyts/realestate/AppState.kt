package com.duyts.realestate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.duyts.feature.home.navigation.HOME_ROUTE
import com.duyts.feature.home.navigation.navigateToHome
import com.duyts.feature.login.navigation.navigateToLogin
import com.duyts.feature.setting.navigation.navigateToSetting
import com.duyts.realestate.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberAppState(
	coroutineScope: CoroutineScope = rememberCoroutineScope(),
	navController: NavHostController = rememberNavController()
): AppState {
	return remember(coroutineScope, navController) {
		AppState(coroutineScope, navController)
	}
}

@Stable
class AppState(coroutineScope: CoroutineScope, val navController: NavHostController) {

	val currentDestination: NavDestination?
		@Composable get() = navController.currentBackStackEntryAsState().value?.destination
	val currentTopLevelDestination: TopLevelDestination?
		@Composable get() = when (currentDestination?.route) {
			HOME_ROUTE -> TopLevelDestination.HOME
			else -> null
		}

	val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

	fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
		val topLevelNavOptions = navOptions {
			popUpTo(navController.graph.findStartDestination().id) {
				saveState = true
			}

			launchSingleTop = true
			restoreState = true

		}
		when (topLevelDestination) {
			TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
			TopLevelDestination.SETTINGS -> navController.navigateToSetting(topLevelNavOptions)
			TopLevelDestination.FAVORITE -> navController.navigateToLogin(topLevelNavOptions)
		}

	}
}