import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

/**
 * @author Vitor Ota
 * @since 28/05/2019
 */

class FeatureWithDataPlugin : Plugin<Project> {

    val implementation = "implementation"
    val kapt = "kapt"
    val testImplementation = "testImplementation"
    val androidTestImplementation = "androidTestImplementation"

    override fun apply(project: Project) {
        configureDependencies(project)
    }

    private fun configureDependencies(project: Project) {
        project.dependencies {
            configDependencies(this)
            configTestDependencies(this)
            configAndroidTestDependencies(this)
        }
    }

    private fun configDependencies(dependencies: DependencyHandlerScope) {
        dependencies {
            add(implementation, project(Modules.Libraries.uicomponents))
            add(implementation, project(Modules.Libraries.network))
            add(implementation, project(Modules.Libraries.common))

            add(implementation, Libraries.kotlin)
            add(implementation, Libraries.kotlinExtensions)

            add(implementation, Libraries.navigationFragment)
            add(implementation, Libraries.navigationUI)

            add(implementation, Libraries.room)
            add(implementation, Libraries.roomKtExtensionsAndCoroutineSupport)
            add(kapt, KaptLibraries.room)

            add(implementation, Libraries.lifecycle)
            add(kapt, KaptLibraries.lifecycle)

            add(implementation, Libraries.coroutines)
            add(implementation, Libraries.coroutinesAndroid)

            add(implementation, Libraries.koin)
            add(implementation, Libraries.koinViewModel)
        }

    }

    private fun configTestDependencies(dependencies: DependencyHandlerScope) {
        dependencies {
            add(testImplementation, project(Modules.Libraries.testCommon))

            add(testImplementation, TestLibraries.jUnit)
            add(testImplementation, TestLibraries.mockk)
            add(testImplementation, TestLibraries.androidCoreTesting)
            add(testImplementation, TestLibraries.coroutinesTest)
        }
    }

    private fun configAndroidTestDependencies(dependencies: DependencyHandlerScope) {
        dependencies {
            add(androidTestImplementation, TestLibraries.androidTestRunner)
            add(androidTestImplementation, TestLibraries.espresso)
        }
    }

}