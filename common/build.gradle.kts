plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.materialIconsExtended)
            }
        }
        val androidMain by getting {
            dependencies {
                val lifecycle_version = "2.6.1"
                implementation("com.github.mik3y:usb-serial-for-android:3.5.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
                implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
                implementation ("com.squareup.retrofit2:retrofit:2.9.0")
                implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
                implementation ("com.squareup.okhttp3:logging-interceptor:3.12.1")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation("com.fazecast:jSerialComm:2.9.3")
                api(compose.desktop.common)
            }
        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
