package com.duyts.feature.maps.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.duyts.feature.maps.MapRoute


const val MAP_ROUTE = "MAP_ROUTE"
fun NavController.navigateToMap(navOptions: NavOptions) = navigate(MAP_ROUTE, navOptions)

fun NavGraphBuilder.mapScreen() {
	composable(route = MAP_ROUTE) {
		MapRoute()
	}
}