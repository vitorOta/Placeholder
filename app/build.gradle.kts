plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
}

android {
    defaultConfig {
        applicationId = "com.vitorota.placeholder"
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
    implementation(Libraries.kotlin)
    implementation(Libraries.koin)
    implementation(Libraries.navigationUI)
    implementation(Libraries.navigationFragment)

    implementation(project(Modules.uicomponents))
    implementation(project(Modules.actions))

    implementation(project(Modules.albums))
    implementation(project(Modules.posts))
    implementation(project(Modules.todo))
}
