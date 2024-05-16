package com.duyts.feature.maps

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun MapRoute(
	viewModel: MapViewModel = hiltViewModel()
) {
	MapScreen()
}

@Composable
internal fun MapScreen(){

}

@Preview
@Composable
private fun MapScreenPreview() {
	MapScreen()
}