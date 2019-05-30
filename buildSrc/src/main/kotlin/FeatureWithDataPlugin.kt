import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

/**
 * @author Vitor Ota
 * @since 28/05/2019
 */

class FeatureWithDataPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        configureDependencies(project)
    }

    fun configureDependencies(project: Project) {
        val implementation = "implementation"
        val kapt = "kapt"
        val testImplementation = "testImplementation"
        val androidTestImplementation = "androidTestImplementation"

        project.dependencies {
            add(implementation, project(Modules.Libraries.uicomponents))
            add(implementation, project(Modules.Libraries.network))

            add(implementation, Libraries.kotlin)
            add(implementation, Libraries.kotlinExtensions)

            add(implementation, Libraries.navigationFragment)
            add(implementation, Libraries.navigationUI)

            add(implementation, Libraries.room)
            add(implementation, Libraries.roomKtExtensionsAndCoroutineSupport)
            add(kapt, KaptLibraries.room)

            add(implementation, Libraries.coroutines)
            add(implementation, Libraries.coroutinesAndroid)

            add(implementation, Libraries.koin)
            add(implementation, Libraries.koinViewModel)


            add(testImplementation, TestLibraries.jUnit)

            add(androidTestImplementation, TestLibraries.androidTestRunner)
            add(androidTestImplementation, TestLibraries.espresso)
        }
    }
}