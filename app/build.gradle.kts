plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
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
    implementation(Modules.Libraries.uicomponents)
    //    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//    implementation 'androidx.appcompat:appcompat:1.0.2'
//    implementation 'androidx.core:core-ktx:1.0.2'
//    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test:runner:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
}
