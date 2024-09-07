package com.duyts.feature.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.duyts.feature.home.component.NewsFeedCard


@Composable
internal fun HomeRoute(
	viewModel: HomeViewModel = hiltViewModel()
) {
	HomeScreen()
}

@Composable
internal fun HomeScreen() {
	NewsFeedCard(modifier = Modifier, mutableListOf())
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
	NewsFeedCard(modifier = Modifier, mutableListOf())
}
