plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.android.hilt.dagger)
    kotlin("kapt")

}

android {
    namespace = "com.creativeitinstitute.platzi2401"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.creativeitinstitute.platzi2401"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
//    implementation(libs.okhttp)
//    implementation(libs.okhttp.loggin.inceptor)
    //lottie
    implementation(libs.lottie)

    //ssp sdp
    implementation("com.intuit.ssp:ssp-android:1.1.1")
    implementation("com.intuit.sdp:sdp-android:1.1.1")

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)


    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // lifecycle ViewModel
    implementation(libs.android.viewmodel)
    implementation(libs.android.livedata)
    implementation(libs.fragment.ktx)





}