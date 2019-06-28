plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0"
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
    //    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation(Libraries.kotlin)
    implementation(Libraries.appCompat)
    implementation(Libraries.lifecycle)
    implementation(Libraries.retrofitCoroutinesAdapter)

    kapt(KaptLibraries.lifecycle)
}
