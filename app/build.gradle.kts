plugins {
    id(Dependency.GradlePlugin.ANDROID_APPLICATION)
    id(Dependency.GradlePlugin.KOTLIN_ANDROID)
}

android {
    namespace = "com.daily.daily"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.daily.daily"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.Google.MATERIAL)
    implementation(Dependency.UnitTest.JUNIT)
    implementation(Dependency.AndroidTest.ANDROID_JUNIT)
    implementation(Dependency.AndroidTest.ESPRESSO_CORE)
}