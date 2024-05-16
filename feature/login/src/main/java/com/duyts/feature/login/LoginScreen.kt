package com.duyts.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun LoginRoute(
	viewModel: LoginViewModel = hiltViewModel()
) {
	LoginScreen()
}

@Composable
internal fun LoginScreen() {
	val username = remember { mutableStateOf("") }
	val password = remember { mutableStateOf("") }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Spacer(modifier = Modifier.height(20.dp))
		OutlinedTextField(
			modifier = Modifier
				.fillMaxWidth()
				.padding(12.dp),
			value = username.value,
			onValueChange = { username.value = it },
			label = { Text("Username") },
			singleLine = true
		)
		Spacer(modifier = Modifier.height(8.dp))
		OutlinedTextField(
			modifier = Modifier
				.fillMaxWidth()
				.padding(12.dp),
			value = username.value,
			onValueChange = { password.value = it },
			label = { Text(text = "Password") },
			visualTransformation = PasswordVisualTransformation(),
			keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
			singleLine = true,
		)

		Spacer(modifier = Modifier.height(16.dp))

		Button(
			onClick = {},
			modifier = Modifier.fillMaxWidth(0.5F),
			colors = ButtonDefaults.buttonColors()
		) {
			Text("Login", color = Color.White, fontSize = 18.sp)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
	LoginScreen()
}
