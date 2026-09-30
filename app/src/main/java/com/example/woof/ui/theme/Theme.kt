package com.example.woof.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Esquema completo utilizado cuando el dispositivo está en tema claro.
 */
private val LightColors = lightColorScheme(
    primary = mdThemeLightPrimary,
    onPrimary = mdThemeLightOnPrimary,
    primaryContainer = mdThemeLightPrimaryContainer,
    onPrimaryContainer = mdThemeLightOnPrimaryContainer,
    secondary = mdThemeLightSecondary,
    onSecondary = mdThemeLightOnSecondary,
    secondaryContainer = mdThemeLightSecondaryContainer,
    onSecondaryContainer = mdThemeLightOnSecondaryContainer,
    tertiary = mdThemeLightTertiary,
    onTertiary = mdThemeLightOnTertiary,
    tertiaryContainer = mdThemeLightTertiaryContainer,
    onTertiaryContainer = mdThemeLightOnTertiaryContainer,
    error = mdThemeLightError,
    errorContainer = mdThemeLightErrorContainer,
    onError = mdThemeLightOnError,
    onErrorContainer = mdThemeLightOnErrorContainer,
    background = mdThemeLightBackground,
    onBackground = mdThemeLightOnBackground,
    surface = mdThemeLightSurface,
    onSurface = mdThemeLightOnSurface,
    surfaceVariant = mdThemeLightSurfaceVariant,
    onSurfaceVariant = mdThemeLightOnSurfaceVariant,
    outline = mdThemeLightOutline,
    inverseOnSurface = mdThemeLightInverseOnSurface,
    inverseSurface = mdThemeLightInverseSurface,
    inversePrimary = mdThemeLightInversePrimary,
    surfaceTint = mdThemeLightSurfaceTint,
    outlineVariant = mdThemeLightOutlineVariant,
    scrim = mdThemeLightScrim
)

/**
 * Esquema completo utilizado cuando el dispositivo está en tema oscuro.
 */
private val DarkColors = darkColorScheme(
    primary = mdThemeDarkPrimary,
    onPrimary = mdThemeDarkOnPrimary,
    primaryContainer = mdThemeDarkPrimaryContainer,
    onPrimaryContainer = mdThemeDarkOnPrimaryContainer,
    secondary = mdThemeDarkSecondary,
    onSecondary = mdThemeDarkOnSecondary,
    secondaryContainer = mdThemeDarkSecondaryContainer,
    onSecondaryContainer = mdThemeDarkOnSecondaryContainer,
    tertiary = mdThemeDarkTertiary,
    onTertiary = mdThemeDarkOnTertiary,
    tertiaryContainer = mdThemeDarkTertiaryContainer,
    onTertiaryContainer = mdThemeDarkOnTertiaryContainer,
    error = mdThemeDarkError,
    errorContainer = mdThemeDarkErrorContainer,
    onError = mdThemeDarkOnError,
    onErrorContainer = mdThemeDarkOnErrorContainer,
    background = mdThemeDarkBackground,
    onBackground = mdThemeDarkOnBackground,
    surface = mdThemeDarkSurface,
    onSurface = mdThemeDarkOnSurface,
    surfaceVariant = mdThemeDarkSurfaceVariant,
    onSurfaceVariant = mdThemeDarkOnSurfaceVariant,
    outline = mdThemeDarkOutline,
    inverseOnSurface = mdThemeDarkInverseOnSurface,
    inverseSurface = mdThemeDarkInverseSurface,
    inversePrimary = mdThemeDarkInversePrimary,
    surfaceTint = mdThemeDarkSurfaceTint,
    outlineVariant = mdThemeDarkOutlineVariant,
    scrim = mdThemeDarkScrim
)

/**
 * Tema general de Woof.
 *
 * @param darkTheme usa automáticamente la preferencia clara u oscura del sistema.
 * @param dynamicColor se deja en false para conservar la paleta personalizada
 * generada para la práctica, aunque el soporte para color dinámico permanece.
 * @param content contenido Compose al que se aplicarán colores, formas y tipografía.
 */
@Composable
fun WoofTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // Selecciona el esquema correspondiente. El color dinámico solo existe en Android 12+.
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColors
        else -> LightColors
    }

    // Sincroniza la barra de estado con la paleta elegida.
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat
                .getInsetsController(window, view)
                .isAppearanceLightStatusBars = !darkTheme
        }
    }

    // MaterialTheme distribuye el sistema visual a todos los composables hijos.
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}
