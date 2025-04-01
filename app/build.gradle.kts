plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.cjmkeke.d2rbooks"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.cjmkeke.d2rbooks"
        minSdk = 26
        targetSdk = 34
        versionCode = 7
        versionName = "7"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("int", "VERSION_CODE", versionCode.toString())
    }

    signingConfigs {
        create("release") {
            storeFile = file("D:\\appkey\\diablo2.jks") // 키스토어 파일 경로
            storePassword = "cjm6357422"    // 키스토어 비밀번호
            keyAlias = "key0"              // 키 별칭
            keyPassword = "cjm6357422"        // 키 비밀번호
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true

            signingConfig = signingConfigs.getByName("release") // 릴리스 서명 설정
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            firebaseCrashlytics {
                mappingFileUploadEnabled = true
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    viewBinding {
        enable = true
    }
}



dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.play.services.mlkit.text.recognition.common)
    implementation(libs.play.services.mlkit.text.recognition.korean)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.crashlytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.google.android.recaptcha:recaptcha:18.4.0")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("com.google.firebase:firebase-auth:22.1.1")

    implementation("com.github.zcweng:switch-button:0.0.3@aar")

    implementation ("com.google.code.gson:gson:2.8.9")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.github.bumptech.glide:glide:4.12.0")

    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation("com.google.mlkit:text-recognition:16.0.0")

    implementation("org.jsoup:jsoup:1.14.3")
    implementation ("androidx.work:work-runtime:2.7.1") // WorkManager 최신 버전
    implementation ("com.google.guava:guava:31.0.1-android") // Guava 라이브러리m
    implementation ("com.android.volley:volley:1.2.1")

    implementation ("io.github.ParkSangGwon:tedpermission-normal:3.4.2")
    implementation("com.github.PhilJay:MPAndroidChart:3.1.0")

}


