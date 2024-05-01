package com.duyts.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.duyts.feature.home.HomeRoute

const val HOME_ROUTE = "HOME_ROUTE"
fun NavController.navigateToHome(navOptions: NavOptions) = navigate(HOME_ROUTE, navOptions)

fun NavGraphBuilder.homeScreen() {
	composable(route = HOME_ROUTE) {
		HomeRoute()
	}
}