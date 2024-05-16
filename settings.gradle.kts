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
include(":core")
include(":core:data")
include(":core:common")
include(":core:model")
include(":core:database")
include(":core:network")
include(":core:ui")
include(":feature")
include(":feature:home")
include(":feature:setting")
include(":feature:login")
include(":feature:maps")
