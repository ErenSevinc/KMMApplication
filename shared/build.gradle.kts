plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Libraries.Shared.Common.ktorCore)
                implementation(Libraries.Shared.Common.ktorJson)
                implementation(Libraries.Shared.Common.ktorLogging)
                implementation(Libraries.Shared.Common.logback)
                implementation(Libraries.Shared.Common.ktorSerialization)
                implementation(Libraries.Shared.Common.ktorContentNegotiation)
                implementation(Libraries.Shared.Common.ktorSerializationJson)
                implementation(Libraries.coroutinesCore)
                implementation(Libraries.Shared.Common.kotlinSerializationCore)
                implementation(Libraries.Shared.Common.koin)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Libraries.Shared.Android.ktorClient)
                implementation(Libraries.Shared.Android.coroutinesAndroid)
                implementation(Libraries.viewModelLifeCycle)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation(Libraries.Shared.IOS.ktorClient)
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 25
        targetSdk = 32
    }
}