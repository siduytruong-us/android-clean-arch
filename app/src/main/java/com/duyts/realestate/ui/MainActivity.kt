package com.duyts.realestate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.duyts.core.ui.MyApplicationTheme
import com.duyts.realestate.rememberAppState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	private val viewModel: MainActivityViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		val splashScreen = installSplashScreen();
		super.onCreate(savedInstanceState)
		var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

		lifecycleScope.launch {
			lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.uiState
					.onEach {
						uiState = it
					}
					.collect()
			}
		}

		// Keep the splash screen on-screen until the UI state is loaded. This condition is
		// evaluated each time the app needs to be redrawn so it should be fast to avoid blocking
		// the UI.
		splashScreen.setKeepOnScreenCondition {
			when (uiState) {
				MainActivityUiState.Loading -> true
				MainActivityUiState.Success -> false
			}
		}

		setContent {
			val appState = rememberAppState()
			MyApplicationTheme {
				MainApp(appState)
			}
		}
	}
}