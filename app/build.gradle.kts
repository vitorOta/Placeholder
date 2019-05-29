plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
}

android {
    compileSdkVersion(DefaultConfigs.compileSdkVersion)
    defaultConfig {
        applicationId = "com.vitorota.placeholder"
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
    implementation(project(Modules.Libraries.uicomponents))
    implementation(project(Modules.Libraries.actions))
    implementation(project(Modules.Features.albums))
    implementation(project(Modules.Features.posts))
    implementation(project(Modules.Features.todo))
}
