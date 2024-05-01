package com.duyts.feature.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
internal fun HomeRoute() {
	HomeScreen()
}

@Composable
internal fun HomeScreen() {
	Text(text = "Home Page")
}
