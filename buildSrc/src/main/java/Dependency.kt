object Dependency {
    object GradlePlugin {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
        const val HILT_ANDROID = "com.google.dagger.hilt.android"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val CORE_SPLASH_SCREEN = "androidx.core:core-splashscreen:${Versions.CORE_SPLASH_SCREEN}"
        const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE_RUNTIME}"
        const val COMPOSE_MATERIAL3 = "androidx.compose.material3:material3:${Versions.COMPOSE_MATERIAL3}"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE_UI}"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_TOOLING}"
        const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}"
        const val COMPOSE_UI_UTIL = "androidx.compose.ui:ui-util:${Versions.COMPOSE_UI_UTIL}"
        const val LIFECYCLE_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"
        const val HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE}"
        const val LIFECYCLE_RUNTIME_COMPOSE = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.LIFECYCLE}"
        const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    }

    object Libraries {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object UnitTest {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }

    object AndroidTest {
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    }
}