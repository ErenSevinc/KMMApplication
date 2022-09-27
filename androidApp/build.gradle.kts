plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.kmmapplication.android"
        minSdk = 25
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation(Libraries.coroutinesCore)
    implementation(Libraries.AndroidApp.ktorCoroutinesAndroid)
    implementation(Libraries.AndroidApp.composeUI)
    implementation(Libraries.AndroidApp.composeUITooling)
    implementation(Libraries.AndroidApp.composeMaterial)
    implementation(Libraries.AndroidApp.composeFoundation)
    implementation(Libraries.AndroidApp.composeActivity)
    implementation(Libraries.AndroidApp.composeCoil)
    implementation(Libraries.AndroidApp.composeViewModel)
    implementation(Libraries.AndroidApp.composeNavigation)
}