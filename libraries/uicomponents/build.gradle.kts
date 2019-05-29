plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(DefaultConfigs.compileSdkVersion)
    defaultConfig {
        minSdkVersion(DefaultConfigs.minSdkVersion)
        targetSdkVersion(DefaultConfigs.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = DefaultConfigs.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt")
                , "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(Libraries.kotlin)

    api(Libraries.material)
    api(Libraries.appCompat)
    api(Libraries.recyclerView)
    api(Libraries.constraintLayout)
//
//    implementation 'androidx.appcompat:appcompat:1.0.2'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test:runner:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
}
