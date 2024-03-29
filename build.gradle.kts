plugins {
    id(Dependency.GradlePlugin.ANDROID_APPLICATION) version Versions.GRADLE_ANDROID apply false
    id(Dependency.GradlePlugin.ANDROID_LIBRARY) version Versions.GRADLE_ANDROID apply false
    id(Dependency.GradlePlugin.KOTLIN_ANDROID) version Versions.GRADLE_KOTLIN apply false
    id(Dependency.GradlePlugin.HILT_ANDROID) version Versions.HILT apply false
    id(Dependency.GradlePlugin.KTLINT) version Versions.KTLINT
}
