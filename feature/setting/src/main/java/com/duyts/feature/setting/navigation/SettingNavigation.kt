package com.duyts.feature.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.compose.composable
import com.duyts.feature.setting.SettingRoute

const val SETTING_ROUTE = "SETTING_ROUTE"

fun NavController.navigateToSetting(navOptions: NavOptions) = navigate(SETTING_ROUTE, navOptions)

fun NavGraphBuilder.settingScreen() {
	composable(route = SETTING_ROUTE) {
		SettingRoute()
	}
}