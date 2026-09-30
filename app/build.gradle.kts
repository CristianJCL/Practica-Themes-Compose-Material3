import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// Plugins necesarios para crear la aplicación Android con Jetpack Compose.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    // Espacio de nombres utilizado por el código y los recursos generados.
    namespace = "com.example.woof"
    compileSdk = 37

    defaultConfig {
        // Identificador único de instalación de la aplicación.
        applicationId = "com.example.woof"

        // La práctica funciona desde Android 7.0 y conserva el target del codelab.
        minSdk = 24
        targetSdk = 33

        versionCode = 1
        versionName = "1.0"

        // Permite utilizar VectorDrawable en las versiones compatibles.
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            // No se requiere reducción u ofuscación para esta práctica académica.
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }
    }

    // Java 17 es la versión utilizada por el proyecto Android actual.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Kotlin genera bytecode compatible con Java 17.
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_17
        }
    }

    // Habilita Jetpack Compose como sistema de interfaz de usuario.
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Componentes base de AndroidX.
    implementation("androidx.core:core-ktx:1.19.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")
    implementation("androidx.activity:activity-compose:1.13.0")

    // BOM para mantener compatibles las bibliotecas de Compose.
    implementation(platform("androidx.compose:compose-bom:2026.09.00"))

    // Bibliotecas principales de Compose y Material 3.
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Permite utilizar las fuentes Abril Fatface y Montserrat desde Google Fonts.
    implementation("androidx.compose.ui:ui-text-google-fonts:1.12.1")

    // Herramientas de vista previa y depuración de Compose.
    debugImplementation("androidx.compose.ui:ui-tooling")
}
