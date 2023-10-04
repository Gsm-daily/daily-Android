plugins {
    id(Dependency.GradlePlugin.ANDROID_LIBRARY)
    id(Dependency.GradlePlugin.KOTLIN_ANDROID)
}

android {
    namespace = "com.daily.designsystem"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK

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

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.AndroidX.COMPOSE_RUNTIME)
    implementation(Dependency.AndroidX.COMPOSE_MATERIAL3)
    implementation(Dependency.AndroidX.COMPOSE_TOOLING)
    implementation(Dependency.AndroidX.COMPOSE_UI)
    implementation(Dependency.UnitTest.JUNIT)
    implementation(Dependency.AndroidTest.ANDROID_JUNIT)
    implementation(Dependency.AndroidTest.ESPRESSO_CORE)
}
