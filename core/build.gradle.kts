import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "id.barakkastudio.core"
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    tasks.withType().configureEach {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                "-opt-in=androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi",
            )
        }
    }
}

dependencies {

    // DEFAULT DEPENDENCIES
    api(MyDependencies.core_ktx)
    api(MyDependencies.lifecycle_ktx)

    // COMPOSE
    api(MyDependencies.activity_compose)
    api(platform("androidx.compose:compose-bom:2023.06.00"))
    api("androidx.compose.ui:ui")
    api("androidx.compose.ui:ui-graphics")
    api("androidx.compose.ui:ui-tooling-preview")
    api("androidx.compose.material3:material3")
    api("androidx.compose.material3:material3-window-size-class")
    api(MyDependencies.navigation_compose)

    // FIREBASE
    api(MyDependencies.realtime_database)

    // TESTING
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // MOCKITO-KOTLIN
    testImplementation(MyDependencies.mockito_kotlin)

    // COROUTINES TEST
    testImplementation(MyDependencies.coroutines_test)

    // REMOTE
    api(MyDependencies.retrofit)
    api(MyDependencies.retrofit2_converter_gson)
    api(MyDependencies.retrofit2_adapter_rxjava2)
    api(MyDependencies.okhttp3)

    // COIL
    api(MyDependencies.coil)

    // Hilt
    implementation(MyDependencies.hilt_android)
    kapt(MyDependencies.hilt_android_compiler)
    api(MyDependencies.hilt_compose) {
        exclude("androidx.lifecycle", "lifecycle-viewmodel-ktx")
    }
    kapt(MyDependencies.hilt_compose_compiler)

    // Room
    api(MyDependencies.room)
    kapt(MyDependencies.room_kapt)
    api(MyDependencies.room_ktx)

    // PAGER
    api(MyDependencies.accompanist_pager)
    api(MyDependencies.accompanist_pager_indicator)

    // System UI Controller
    api(MyDependencies.accompanist_systemuicontroller)
}