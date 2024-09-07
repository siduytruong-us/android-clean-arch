package com.duyts.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
private fun NewsFeedCardHeader() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.height(50.dp)
	) {
		Image(
			modifier = Modifier
				.weight(1f)
				.fillMaxHeight()
				.padding(end = 10.dp),
			contentScale = ContentScale.Crop,
			painter = rememberAsyncImagePainter("https://www.google.com/url?sa=i&url=https%3A%2F%2Ffreeiconshop.com%2Ficon%2Fpng-icon-flat%2F&psig=AOvVaw2nGhe_2YDd9-zXixQ3qS91&ust=1715919885406000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIDevOypkYYDFQAAAAAdAAAAABAE"),
			contentDescription = null
		)
		Column(
			modifier = Modifier
				.weight(4f)
				.fillMaxWidth()
				.fillMaxHeight(),
			verticalArrangement = Arrangement.Center
		) {
			Text(text = "Username", style = MaterialTheme.typography.bodySmall)
			Text(text = "Username", style = MaterialTheme.typography.bodySmall)
		}
		IconButton(
			modifier = Modifier
				.fillMaxHeight()
				.weight(1f),
			onClick = { /*TODO*/ }) {
			Icon(
				imageVector = Icons.Filled.MoreVert,
				contentDescription = "More options",
				tint = Color.Black
			)
		}
	}
}


@Composable
private fun NewsFeedImages(images: List<String>) {
	LazyHorizontalGrid(
		modifier = Modifier.heightIn(max = 200.dp),
		rows = GridCells.Fixed(3),
		contentPadding = PaddingValues(8.dp),
	) {
		items(images) { url ->
			Image(
				painter = rememberAsyncImagePainter(model = url),
				contentDescription = "Grid image",
				modifier = Modifier
					.aspectRatio(1f)
					.padding(4.dp)
			)
		}
	}
}

@Composable
private fun NewsFeedComment() {
	Column(
		modifier = Modifier
			.padding(vertical = 8.dp)
			.fillMaxWidth()
	) {
		Text(text = "Username - TimeStamp", style = MaterialTheme.typography.labelMedium)
		Text(text = "This is a comment of user!", style = MaterialTheme.typography.bodyMedium)
	}
}

@Composable
private fun NewsFeedComments() {
	NewsFeedComment()
	NewsFeedComment()
}

@Composable
fun NewsFeedCard(modifier: Modifier, images: List<String>) {
	val listState = rememberLazyListState()
	LazyColumn(
		modifier = Modifier.fillMaxSize(),
		state = listState
	) {
		item(4) {
			Card(
				shape = RoundedCornerShape(2.dp)
			) {
				Column(modifier = Modifier.fillMaxWidth()) {
					NewsFeedCardHeader()
					NewsFeedImages(images)
					NewsFeedComments()
				}
			}
		}
	}
}


@Preview(showBackground = true)
@Composable
fun NewsFeedCardPreview() {
	NewsFeedCard(Modifier, mutableListOf())
}

@Preview(showBackground = true)
@Composable
fun NewsFeedCardHeaderPreview() {
	NewsFeedCardHeader()
}