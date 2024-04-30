package com.duyts.core.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Navigation bar with content slot. Wraps Material 3 [NavigationBar].
 *
 * @param modifier Modifier to be applied to the navigation bar.
 * @param content Destinations inside the navigation bar. This should contain multiple
 * [NavigationBarItem]s.
 */
@Composable
fun AppNavigationBar(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
	NavigationBar(
		modifier = modifier,
		contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
		tonalElevation = 0.dp,
		content = content
	)
}

@Composable
fun RowScope.AppNavigationBarItem(
	selected: Boolean,
	onClick: () -> Unit, modifier: Modifier = Modifier,
	enabled: Boolean = true,
	icon: @Composable () -> Unit,
	selectedIcon: @Composable () -> Unit,
	label: @Composable () -> Unit,
) {
	NavigationBarItem(
		selected = selected,
		onClick = onClick,
		icon = if (selected) selectedIcon else icon,
		modifier = modifier,
		enabled = enabled,
		label = label,
		colors = NavigationBarItemDefaults.colors(
			selectedIconColor = AppNavigationDefaults.navigationSelectedItemColor(),
			unselectedIconColor = AppNavigationDefaults.navigationContentColor(),
			selectedTextColor = AppNavigationDefaults.navigationSelectedItemColor(),
			unselectedTextColor = AppNavigationDefaults.navigationContentColor(),
			indicatorColor = AppNavigationDefaults.navigationIndicatorColor(),
		),
	)

}


object AppNavigationDefaults {
	@Composable
	fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

	@Composable
	fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

	@Composable
	fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}