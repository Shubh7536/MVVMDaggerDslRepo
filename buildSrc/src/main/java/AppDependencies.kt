import Versions.Compose.compose_activity_version
import Versions.Compose.compose_version
import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val googleMaterialTheme="com.google.android.material:material:1.6.1"


    //compose
    object Compose{
        val composeUI="androidx.compose.ui:ui:${compose_version}"
        val composeMaterialTheme="androidx.compose.material:material:${compose_version}"
        val composePreview="androidx.compose.ui:ui-tooling-preview:$compose_version"
        val composeActivity="androidx.activity:activity-compose:${compose_activity_version}"
    }


    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val composeJUnit="androidx.compose.ui:ui-test-junit4:${compose_version}"
    private val composeUITooling="androidx.compose.ui:ui-tooling:${compose_version}"
    private val composeUITestManifest="androidx.compose.ui:ui-test-manifest:$compose_version"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(Compose.composeUI)
        add(Compose.composeMaterialTheme)
        add(Compose.composePreview)
        add(Compose.composeActivity)
        add(googleMaterialTheme)

    }

    val cacheModuleLibraries= arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(googleMaterialTheme)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(composeJUnit)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val debugImplementationLibraries= arrayListOf<String>().apply {
        add(composeUITooling)
        add(composeUITestManifest)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>){
    list.forEach{ dependency->
        add("debugImplementation",dependency)
    }
}