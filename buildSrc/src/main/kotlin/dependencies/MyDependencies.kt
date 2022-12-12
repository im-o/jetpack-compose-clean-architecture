package dependencies

/** Created by github.com/im-o on 12/13/2022. */

object MyDependencies {
    // DEFAULT DEPENDENCIES
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    const val lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_ktx_version}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose_version}"
    const val ui_compose = "androidx.compose.ui:ui:${Versions.compose_ui_version}"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_ui_version}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.app_compat_version}"
    const val material_compose = "androidx.compose.material:material:${Versions.material_compose_version}"
    const val junit = "junit:junit:${Versions.junit_version}"
    const val test_ext_junit = "androidx.test.ext:junit:${Versions.test_ext_junit_version}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_test_version}"
    const val junit_compose = "androidx.compose.ui:ui-test-junit4:${Versions.compose_ui_version}"
    const val ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_ui_version}"
    const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose_ui_version}"

    const val navigation_compose = "androidx.navigation:navigation-compose:${Versions.navigation_compose}"

    // REMOTE
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofit2_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    const val retrofit2_adapter_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_version}"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3_version}"

    //Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"
    const val hilt_navigation = "androidx.hilt:hilt-navigation-fragment:${Versions.hilt_navigation}"
    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_ktx_version}"

    //Room
    const val room = "androidx.room:room-runtime:${Versions.room_version}"
    const val room_kapt = "androidx.room:room-compiler:${Versions.room_version}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room_version}" // optional - Kotlin Extensions and Coroutines support for Room
}