// Configura los repositorios usados por los plugins de Gradle.
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Centraliza los repositorios de dependencias para todos los módulos.
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// Nombre del proyecto y registro del módulo principal.
rootProject.name = "Woof"
include(":app")
