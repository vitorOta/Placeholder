plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
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

    api(Libraries.retrofit)
    api(Libraries.gson)
    implementation(Libraries.retrofitGsonConverter)
    api(Libraries.retrofitCoroutinesAdapter)
}
