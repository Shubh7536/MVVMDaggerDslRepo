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

    object Dagger2{
        val dagger2="com.google.dagger:dagger:2.40.5"
        val daggerAndroidSupport="com.google.dagger:dagger-android-support:2.27"
        val daggerKapt="com.google.dagger:dagger-compiler:2.40.5"
    }

    object AndroidLifecycle{
        val lifeCycleViewModel="androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        val lifecycleLiveData="androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
        val lifeCycleCommon="androidx.lifecycle:lifecycle-common-java8:2.5.1"
        val lifeCycleRuntime="androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        val lifeCycleCompilerKapt="androidx.lifecycle:lifecycle-compiler:2.5.1"
    }

    object Retrofit{
        val retrofit="com.squareup.retrofit2:retrofit:2.9.0"
        val retrofitGsonConverter="com.squareup.retrofit2:converter-gson:2.9.0"
    }

    object OkHttp{
        val okHttptBom="com.squareup.okhttp3:okhttp-bom:4.9.1"
        val okHttpt="com.squareup.okhttp3:okhttp"
        val okHttptLoggingInterceptor="com.squareup.okhttp3:logging-interceptor"
    }

    object Coroutine{
        val coroutineCore="org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
        val coroutineAndroid="org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"

    }

    object NavigationCompose{
        val navCompose="androidx.navigation:navigation-compose:2.5.1"
        val navigationRuntime="androidx.navigation:navigation-runtime-ktx:2.4.2"
    }

    object GoogleComponent{
        val accompanistPager="com.google.accompanist:accompanist-pager:0.23.1"
        val accompanistPagerIndicator="com.google.accompanist:accompanist-pager-indicators:0.23.1"
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
        add(Dagger2.dagger2)
        add(Dagger2.daggerAndroidSupport)
        add(AndroidLifecycle.lifecycleLiveData)
        add(AndroidLifecycle.lifeCycleViewModel)
        add(AndroidLifecycle.lifeCycleCommon)
        add(AndroidLifecycle.lifeCycleRuntime)
        add(NavigationCompose.navCompose)
        add(NavigationCompose.navigationRuntime)
        add(GoogleComponent.accompanistPager)
        add(GoogleComponent.accompanistPagerIndicator)
    }

    val cacheModuleLibraries= arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(googleMaterialTheme)
    }

    val remoteModuleLibraries= arrayListOf<String>().apply {
        add(Retrofit.retrofit)
        add(Retrofit.retrofitGsonConverter)
        add(OkHttp.okHttpt)
        add(OkHttp.okHttptBom)
        add(OkHttp.okHttptLoggingInterceptor)
        add(Dagger2.dagger2)
        add(Dagger2.daggerAndroidSupport)
        add(Coroutine.coroutineCore)
        add(Coroutine.coroutineAndroid)
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

    val kaptLibraries= arrayListOf<String>().apply {
        add(Dagger2.daggerKapt)
        add(AndroidLifecycle.lifeCycleCompilerKapt)
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
