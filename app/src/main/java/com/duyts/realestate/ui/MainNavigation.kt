package com.duyts.realestate.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.duyts.feature.home.navigation.HOME_ROUTE
import com.duyts.feature.home.navigation.homeScreen
import com.duyts.feature.login.navigation.loginScreen
import com.duyts.feature.maps.navigation.mapScreen
import com.duyts.feature.setting.navigation.settingScreen
import com.duyts.realestate.AppState

@Composable
fun NavHost(appState: AppState) {
	val navController = appState.navController

	NavHost(navController = navController, startDestination = HOME_ROUTE) {
//		composable("main") { MyModelScreen(modifier = Modifier.padding(16.dp)) }
		homeScreen()
		settingScreen()
		mapScreen()
		loginScreen()
	}
}