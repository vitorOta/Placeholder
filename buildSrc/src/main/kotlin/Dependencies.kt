/**
 * @author Vitor Ota
 * @since 28/05/2019
 */

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object Libraries {
    const val material = "com.google.android.material:material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinExtensions = "androidx.core:core-ktx:${Versions.kotlinExtensions}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtExtensionsAndCoroutineSupport = "androidx.room:room-ktx:${Versions.room}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

}

object KaptLibraries {
    const val room = "androidx.room:room-compiler:${Versions.room}"
    const val lifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
}

object TestLibraries {
    //test
    const val jUnit = "junit:junit:${Versions.jUnit}"

    //androidTest
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Modules {
    const val app = ":app"

    //libraries
    const val actions = ":libraries:actions"
    const val network = ":libraries:network"
    const val uicomponents = ":libraries:uicomponents"
    const val common = ":libraries:common"

    //features
    const val albums = ":features:albums"
    const val posts = ":features:posts"
    const val todo = ":features:todo"
}