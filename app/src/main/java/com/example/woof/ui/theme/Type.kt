package com.example.woof.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp

/**
 * Fuentes indicadas por la práctica.
 *
 * Compose 1.12 permite obtener Google Fonts mediante el proveedor
 * predeterminado de Google Play Services sin guardar archivos TTF
 * dentro del repositorio.
 */
private val abrilFatface = FontFamily(
    Font(googleFont = GoogleFont("Abril Fatface"))
)

private val montserrat = FontFamily(
    Font(
        googleFont = GoogleFont("Montserrat"),
        weight = FontWeight.Normal
    ),
    Font(
        googleFont = GoogleFont("Montserrat"),
        weight = FontWeight.Bold
    )
)

/**
 * Escala tipográfica utilizada por la aplicación Woof.
 *
 * El título principal usa Abril Fatface y el contenido utiliza
 * Montserrat, tal como se propone en el codelab de Material 3.
 */
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = abrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
