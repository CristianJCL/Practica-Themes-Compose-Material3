package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.Dog
import com.example.woof.data.dogs
import com.example.woof.ui.theme.WoofTheme

/**
 * Activity principal de la práctica.
 *
 * Se encarga únicamente de iniciar Compose y aplicar WoofTheme a toda
 * la jerarquía visual de la aplicación.
 */
class MainActivity : ComponentActivity() {

    /**
     * Punto de entrada de la Activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // WoofTheme distribuye colores, tipografía y formas de Material 3.
            WoofTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WoofApp()
                }
            }
        }
    }
}

/**
 * Estructura principal de la aplicación.
 *
 * Scaffold reserva el espacio de la barra superior y entrega el padding
 * correcto a la lista para evitar que el contenido quede debajo del app bar.
 */
@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) { contentPadding ->
        LazyColumn(contentPadding = contentPadding) {
            // LazyColumn solo compone los elementos necesarios de la lista.
            items(
                items = dogs,
                key = { dog -> dog.name }
            ) { dog ->
                DogItem(
                    dog = dog,
                    modifier = Modifier.padding(
                        dimensionResource(R.dimen.padding_small)
                    )
                )
            }
        }
    }
}

/**
 * Tarjeta que representa un perro dentro de la lista.
 *
 * @param dog datos utilizados para llenar la tarjeta.
 * @param modifier modificadores aplicados desde el componente padre.
 */
@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    // Card obtiene automáticamente su estilo desde MaterialTheme.
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DogIcon(dog.imageResourceId)

            DogInformation(
                dogName = dog.name,
                dogAge = dog.age
            )
        }
    }
}

/**
 * Barra superior centrada con el logotipo y el nombre de la aplicación.
 *
 * @param modifier permite personalizar la posición o tamaño desde el exterior.
 */
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_woof_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                )

                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

/**
 * Avatar visual del perro.
 *
 * El vector se recorta con MaterialTheme.shapes.small, demostrando que
 * la forma definida en Shape.kt se aplica desde el tema.
 *
 * @param dogIcon identificador del recurso gráfico.
 * @param modifier modificadores opcionales del componente.
 */
@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(dogIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
    )
}

/**
 * Bloque de texto con el nombre y la edad.
 *
 * Cada Text utiliza un estilo de la escala tipográfica personalizada
 * en lugar de definir tamaño y fuente directamente en este archivo.
 *
 * @param dogName recurso con el nombre del perro.
 * @param dogAge edad del perro.
 * @param modifier modificadores opcionales.
 */
@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.padding_small)
            )
        )

        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * Vista previa del resultado con el esquema claro personalizado.
 */
@Preview(
    name = "Woof - Light",
    showBackground = true
)
@Composable
fun WoofLightPreview() {
    WoofTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        WoofApp()
    }
}

/**
 * Vista previa del resultado con el esquema oscuro personalizado.
 */
@Preview(
    name = "Woof - Dark",
    showBackground = true
)
@Composable
fun WoofDarkPreview() {
    WoofTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        WoofApp()
    }
}
