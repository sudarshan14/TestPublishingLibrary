import java.io.FileInputStream
import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val githubProperties = Properties()
if (file("local.properties").exists()) {
    githubProperties.load(FileInputStream(file("local.properties")))
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/sudarshan14/TestPublishingLibrary")
            credentials{
                username = (githubProperties["gh_username"] ?: System.getenv("USERNAME")).toString()
                password = (githubProperties["gh_key"] ?: System.getenv("TOKEN")).toString()
            }
        }
    }
}

rootProject.name = "TestPublishingLibrary"
include(":app")
include(":mathlibrary")
