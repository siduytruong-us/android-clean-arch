package com.duyts.realestate.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.duyts.core.ui.icon.AppIcon
import kotlin.enums.enumEntries

enum class TopLevelDestination(
	val selectedIcon: ImageVector,
	val unselectedIcon: ImageVector,
	val iconText: String,
	val titleText: String,
) {
	HOME(
		selectedIcon = AppIcon.RoundedHome,
		unselectedIcon = AppIcon.OutlinedHome,
		iconText = "HomeIcon",
		titleText = "Home"
	),

	SETTINGS(
		selectedIcon = AppIcon.RoundedSettings,
		unselectedIcon = AppIcon.OutlinedSettings,
		iconText = "SettingsIcon",
		titleText = "Settings"
	),

	FAVORITE(
		selectedIcon = AppIcon.RoundedFavorite,
		unselectedIcon = AppIcon.OutlinedFavorite,
		iconText = "FavoriteIcon",
		titleText = "Favorite"
	)
}