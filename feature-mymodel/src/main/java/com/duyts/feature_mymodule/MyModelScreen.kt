package com.duyts.feature_mymodule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.duyts.core.model.Property
import com.duyts.core.ui.MyApplicationTheme

@Composable
fun MyModelScreen(modifier: Modifier = Modifier, viewModel: MyModelViewModel = hiltViewModel()) {
    val items by viewModel.uiState.collectAsStateWithLifecycle()

    when (items) {
        is MyModelUiState.Success -> {
            MyModelScreen(
                items = (items as MyModelUiState.Success).data,
                onSave = { name -> viewModel.addMyModel(name) },
                modifier = modifier
            )
        }
        is MyModelUiState.Error -> {
            Text(text = (items as MyModelUiState.Error).throwable.message.orEmpty())
        }
        else -> {}
    }
}

@Composable
internal fun MyModelScreen(
    items: List<Property>, onSave: (name: String) -> Unit, modifier: Modifier = Modifier
) {
    Column(modifier) {
        var nameMyModel by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(value = nameMyModel, onValueChange = { nameMyModel = it })

            Button(modifier = Modifier.width(96.dp), onClick = { onSave(nameMyModel) }) {
                Text("Save")
            }
        }
        items.forEach {
            Text("Saved item: $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MyApplicationTheme {
        MyModelScreen(fakeProperties, onSave = {})
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    MyApplicationTheme {
        MyModelScreen(fakeProperties, onSave = {})
    }
}

private val fakeProperties = listOf(
    Property(1, "Title1"), Property(2, "Title2"), Property(3, "Title3")
)