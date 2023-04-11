plugins {
    kotlin("kapt")
    id(Dependency.GradlePlugin.ANDROID_LIBRARY)
    id(Dependency.GradlePlugin.KOTLIN_ANDROID)
    id(Dependency.GradlePlugin.HILT_ANDROID)
}

android {
    namespace = "com.daily.presentation"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
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

    implementation(project(":designsystem"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.Google.MATERIAL)
    implementation(Dependency.Google.HILT_ANDROID)
    kapt(Dependency.Google.HILT_COMPILER)
    implementation(Dependency.AndroidX.COMPOSE_RUNTIME)
    implementation(Dependency.AndroidX.COMPOSE_MATERIAL3)
    implementation(Dependency.AndroidX.COMPOSE_TOOLING)
    implementation(Dependency.UnitTest.JUNIT)
    implementation(Dependency.AndroidTest.ANDROID_JUNIT)
    implementation(Dependency.AndroidTest.ESPRESSO_CORE)
    implementation(Dependency.AndroidX.NAVIGATION_COMPOSE)
    implementation(Dependency.AndroidX.COMPOSE_UI_UTIL)
}