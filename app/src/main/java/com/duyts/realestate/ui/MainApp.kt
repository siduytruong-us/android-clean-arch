package com.duyts.realestate.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.duyts.core.ui.component.AppNavigationBar
import com.duyts.core.ui.component.AppNavigationBarItem
import com.duyts.realestate.navigation.TopLevelDestination

@Composable
fun MainApp(modifier: Modifier = Modifier) {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		MainAppUi()
	}
}

@Composable
internal fun MainAppUi() {
	Scaffold(
		modifier = Modifier,
		containerColor = Color.Transparent,
		contentColor = MaterialTheme.colorScheme.onBackground,
		contentWindowInsets = WindowInsets(0, 0, 0, 0),
		bottomBar = { MainAppBottomBar(TopLevelDestination.entries) }
	) { padding ->
		Row(
			Modifier
				.fillMaxSize()
				.padding(padding)
				.consumeWindowInsets(padding)
				.windowInsetsPadding(
					WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
				)
		) {

		}
	}
}

@Composable
internal fun MainAppBottomBar(
	destinations: List<TopLevelDestination>,
	modifier: Modifier = Modifier
) {
	AppNavigationBar(modifier = modifier) {
		destinations.forEach { item ->
			AppNavigationBarItem(
				selected = false,
				onClick = {},
				icon = {
					Icon(imageVector = item.unselectedIcon, contentDescription = null)
				},
				selectedIcon = {
					Icon(imageVector = item.selectedIcon, contentDescription = null)
				},
				label = {
					Text(text = "This is label")
				},
			)
		}

	}
}