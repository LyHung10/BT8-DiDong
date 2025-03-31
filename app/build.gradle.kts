plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "vn.iotstart.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "vn.iotstart.myapplication"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(libs.imageSlideshow)
    implementation(libs.retrofit)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.glide)
    implementation("com.github.ictfoysal:multilibrary:6.0")
    testImplementation(libs.junit)
    implementation(libs.circleindicator)
    implementation(libs.converter.gson)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}