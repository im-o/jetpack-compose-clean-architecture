import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.rivaldy.id.core"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    // DEFAULT DEPENDENCIES
    api(MyDependencies.core_ktx)
    api(MyDependencies.lifecycle_ktx)

    // COMPOSE
    api(MyDependencies.material_compose)
    api(MyDependencies.activity_compose)
    api(MyDependencies.ui_compose)
    api(MyDependencies.ui_tooling_preview)
    api(MyDependencies.navigation_compose)

    // TESTING
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)
    androidTestImplementation(MyDependencies.junit_compose)
    debugImplementation(MyDependencies.ui_tooling)
    debugImplementation(MyDependencies.ui_test_manifest)

    // REMOTE
    api(MyDependencies.retrofit)
    api(MyDependencies.retrofit2_converter_gson)
    api(MyDependencies.retrofit2_adapter_rxjava2)
    api(MyDependencies.okhttp3)
}