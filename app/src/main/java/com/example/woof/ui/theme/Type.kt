package com.example.woof.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.woof.R

/**
 * Familias tipográficas indicadas por la práctica.
 *
 * Los archivos se guardan en res/font para que Woof conserve su identidad
 * visual incluso cuando el dispositivo no tiene conexión a Internet.
 */
private val AbrilFatface = FontFamily(
    Font(R.font.abril_fatface_regular)
)

private val Montserrat = FontFamily(
    Font(
        resId = R.font.montserrat_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.montserrat_bold,
        weight = FontWeight.Bold
    )
)

/**
 * Escala tipográfica Material 3 utilizada en toda la aplicación.
 *
 * El encabezado emplea Abril Fatface y los datos de los perros utilizan
 * Montserrat, de acuerdo con el resultado final del codelab.
 */
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
