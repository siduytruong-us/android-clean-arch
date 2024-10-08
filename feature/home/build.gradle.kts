@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.kapt)
}

android {
	namespace = "com.duyts.feature.home"
	compileSdk = 34

	defaultConfig {
		minSdk = 21

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}

	buildFeatures {
		compose = true
		aidl = false
		buildConfig = false
		renderScript = false
		shaders = false
	}

	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(project(":core:data"))
	implementation(project(":core:ui"))
	implementation(project(":core:common"))
//    androidTestImplementation(project(":core-testing"))

	// Core Android dependencies
	implementation(libs.androidx.activity.compose)

	// Arch Components
	implementation(libs.androidx.lifecycle.runtime.compose)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.lifecycle.viewmodel.compose)
	implementation(libs.androidx.hilt.navigation.compose)

	// Compose
	implementation(libs.androidx.compose.ui)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.compose.material3)
	// Tooling
	debugImplementation(libs.androidx.compose.ui.tooling)
	// Instrumented tests
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)
	debugImplementation(libs.androidx.compose.ui.test.manifest)

	// Hilt Dependency Injection
	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
	// Hilt and instrumented tests.
	androidTestImplementation(libs.hilt.android.testing)
	kaptAndroidTest(libs.hilt.android.compiler)
	// Hilt and Robolectric tests.
	testImplementation(libs.hilt.android.testing)
	kaptTest(libs.hilt.android.compiler)

	// Local tests: jUnit, coroutines, Android runner
	testImplementation(libs.junit)
	testImplementation(libs.kotlinx.coroutines.test)

	// Instrumented tests: jUnit rules and runners
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.androidx.test.runner)
}