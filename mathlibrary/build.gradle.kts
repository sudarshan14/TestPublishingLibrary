import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    `maven-publish`
}

android {
    namespace = "com.amlavati.mathlibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val githubProperties = Properties()
if (rootProject.file("local.properties").exists()) {
    githubProperties.load(FileInputStream(rootProject.file("local.properties")))
}
//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
//github-maven-publish
publishing{
 publications {
     create<MavenPublication>("math-library"){
         run{
             groupId ="com.amlavati"
             artifactId ="mathlib"
             version ="0.1"
             artifact(
                 "build/outputs/aar/mathlibrary-release.aar"
             )
         }

     }
 }

    repositories{
        maven {
            name ="GithubPackages"
            url = uri("https://maven.pkg.github.com/sudarshan14/TestPublishingLibrary")
            credentials{
                username = (githubProperties["gh_username"] ?: System.getenv("USERNAME")).toString()
                password = (githubProperties["gh_key"] ?: System.getenv("TOKEN")).toString()
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}