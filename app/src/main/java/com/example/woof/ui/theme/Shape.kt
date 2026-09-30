package com.example.woof.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Formas personalizadas que Material 3 aplicará a sus componentes.
 *
 * small se usa en los avatares y medium queda disponible para
 * componentes que requieran esquinas asimétricas.
 */
val Shapes = Shapes(
    small = RoundedCornerShape(50.dp),
    medium = RoundedCornerShape(
        bottomStart = 16.dp,
        topEnd = 16.dp
    )
)
