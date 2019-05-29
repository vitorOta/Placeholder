plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
}
apply<FeatureWithDataPlugin>()

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
}
