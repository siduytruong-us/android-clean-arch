pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Real Estate"
include(":app")
include(":feature-mymodel")
include(":core")
include(":core:data")
include(":core:common")
include(":core:model")
include(":core:database")
include(":core:network")
include(":core:ui")
