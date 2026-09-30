package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

/**
 * Modelo inmutable con la información necesaria para dibujar una tarjeta de perro.
 *
 * @property imageResourceId recurso gráfico que representa al perro.
 * @property name recurso de texto con el nombre del perro.
 * @property age edad del perro en años.
 */
data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int
)

/**
 * Datos mostrados por la lista principal.
 *
 * Se mantienen fuera de los composables para separar los datos de la interfaz.
 */
val dogs = listOf(
    Dog(R.drawable.koda, R.string.dog_name_1, 2),
    Dog(R.drawable.lola, R.string.dog_name_2, 16),
    Dog(R.drawable.frankie, R.string.dog_name_3, 2),
    Dog(R.drawable.nox, R.string.dog_name_4, 8),
    Dog(R.drawable.faye, R.string.dog_name_5, 8),
    Dog(R.drawable.bella, R.string.dog_name_6, 14),
    Dog(R.drawable.moana, R.string.dog_name_7, 2),
    Dog(R.drawable.tzeitel, R.string.dog_name_8, 7),
    Dog(R.drawable.leroy, R.string.dog_name_9, 4)
)
