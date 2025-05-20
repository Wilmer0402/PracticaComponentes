package edu.ucne.practicacomponentes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.ucne.practicacomponentes.ui.theme.PracticaComponentesTheme
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    MyButtons()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticaComponentesTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ){
        Text(
            text = ("Wilmer Castillo"),
            color = Color.Green

        )
    }
}

@Composable
fun  MyRow(){
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)){
    }
}

@Composable
fun MyConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button, text) = createRefs()

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button")
        }

        Text(
            text = "Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }
}

@Composable
fun MyText(){
    Text("Wilmer Castillo")
    Text("Wilmer Castillo", color = Color.Green)
    Text("Wilmer Castillo", fontWeight = FontWeight.ExtraBold)
    Text("Wilmer Castillo", fontWeight = FontWeight.Light)
    Text("Wilmer Castillo", style = TextStyle(fontFamily = FontFamily.Cursive))

    Text("Wilmer Castillo",
        style = TextStyle(textDecoration = TextDecoration.LineThrough)
    )

    Text("Wilmer Castillo",
        textDecoration = TextDecoration.Underline
    )

    Text("Wilmer Castillo",
        textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline,TextDecoration.LineThrough)
        )
    )

}

@Composable
fun MyButtons(){
    // Button
    Button(onClick = {

    } ) {
        Text(text = "Front-End")
    }

    //TextButton
    TextButton(
        onClick = {/* Accion al hacer clic */}
    ) {
        Text(text = "Cancelar")
    }

    //OutlinedButton
    OutlinedButton(
        onClick = {/* Accion al hacer clic */}
    ) {
        Text("Agregar")
    }

    // IconButton
    IconButton(
        onClick = {/* Accion al hacer clic */}
    ) {
        Icon(
            Icons.Filled.Share,
            contentDescription = "Compartir"
        )
    }
}

@Composable
fun BasicTextFieldExample() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre completo") },
        placeholder = { Text("Ingrese su nombre") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {}
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showSystemUi = true,showBackground = true)
@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.wilmer),
        contentDescription = "Wilmer",
        modifier = Modifier
            .clip(CircleShape)
    )
    Text(text = "Hola, Bienvenidos",
        color = Color.Red
    )

}

@Preview(showSystemUi = true,showBackground = true)
@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.ThumbUp,
            contentDescription = "MyIcon",
            modifier = modifier
                .clip(CircleShape)
                .size(64.dp)

        )
    }
}

@Preview(showSystemUi = true,showBackground = true)
@Composable
fun MyProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.BottomCenter,

        ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(6.dp))
        LinearProgressIndicator()
    }
}

@Preview(showSystemUi = true,showBackground = true)
@Composable
fun MyCheckBox() {
    var acepto by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(verticalAlignment =  Alignment.CenterVertically) {
            Checkbox(
                checked = acepto,
                onCheckedChange = {acepto = !acepto}
            )
            Text(text = "Acepto el Jetpack Compose")
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MySwitch() {
    var acepto by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Switch(
                checked = acepto,
                onCheckedChange = { acepto = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Reto Jetpack Compose Aceptado",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun  MyRadioButtons() {
    val opciones = listOf("Todos", "Hombres", "Mujeres")
    var seleccionado by remember { mutableStateOf("") }

    Row(verticalAlignment =  Alignment.CenterVertically) {
        opciones.forEach {
                item ->
            RadioButton(
                selected = item == seleccionado,
                onClick = {seleccionado = item}
            )
            Text(text = item)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyComboBox() {
    val ciudades = listOf("SMF", "Tenares", "Salcedo", "Moca")
    var ciudadSeleccionada by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf(false) }

    // Usamos Box como contenedor clickable
    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = ciudadSeleccionada,
            onValueChange = {},
            label = { Text("Ciudad") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Desplegar opciones"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expandido = true },
            readOnly = true
        )

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            ciudades.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        ciudadSeleccionada = item
                        expandido = false
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyDialog() {
    var  dialogoVisible by remember {
        mutableStateOf(true)
    }
    if(dialogoVisible) {
        AlertDialog(
            onDismissRequest = {dialogoVisible = false},
            title = { Text("Titulo del Dialogo") },
            text = {
                Text("Seguro que desea salir de la aplicacion?")
            },
            confirmButton = {
                TextButton(onClick = {
                    // Cerrar la aplicacion
                    dialogoVisible = false
                }) {
                    Text(text = "Aceptar") }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogoVisible = false // Solo cerrar el dialogo
                }) { Text(text = "Cancelar") }
            }
        )
    }
}