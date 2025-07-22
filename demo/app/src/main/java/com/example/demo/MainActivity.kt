package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(24.dp)) {
        DemoTextField()

        Spacer(modifier = Modifier.height(12.dp))
        EmailOutlineTextField()

        Spacer(modifier = Modifier.height(12.dp))
        PasswordOutlineTextField()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DemoTextField() {
    var firstName by remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(value = firstName, onValueChange = { newValue ->
        firstName = newValue
    },
        textStyle = TextStyle(color = Color.Gray, fontSize = 22.sp, fontWeight = FontWeight.Bold),
        label = { Text("First Name") },
        placeholder = { Text(text = "Enter your first name") },
        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color.Green) },
        trailingIcon = {
            IconButton(onClick = {
                firstName = ""
            }) {
                Icon(Icons.Default.Close, contentDescription = null, tint = Color.Green)
            }
        },
        colors = TextFieldDefaults.colors(
            cursorColor = Color.Yellow,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Characters
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
fun EmailOutlineTextField() {
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = email, onValueChange = {newValue ->
        email = newValue
    },
        placeholder = { Text("username/email") },
        label = { Text(text = "username/email") },
        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }
    )
}

@Composable
fun PasswordOutlineTextField() {
    var passwrod by remember {
        mutableStateOf("")
    }

    var isShowPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(value = passwrod, onValueChange = {
        passwrod = it
    },
        label = { Text(text = "Passwrod") },
        placeholder = { Text("Enter passwrod") },
        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = {
                isShowPassword = !isShowPassword
            }) {
                Icon(
                    if (isShowPassword) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        },
        visualTransformation = if(isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun DemoCheckBoxWithTitle(title: String) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.selectable(
            selected = isChecked,
            onClick = { isChecked = !isChecked },
            role = Role.Checkbox
        )
    ) {
//        Checkbox(
//            checked = isChecked, onCheckedChange = null, colors = CheckboxDefaults.colors(
//                checkedColor = Color.Red,
//                uncheckedColor = Color.Green
//            )
//        )

//        cách thay đổi icon
        val icon = if (isChecked) Icons.Filled.Check else Icons.Filled.CheckCircle
        Icon(icon, contentDescription = null)
        Text(title, modifier = Modifier.padding(start = 12.dp))
    }
}

@Composable
fun DemoRadioButtonWithTitle(title: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            role = Role.RadioButton
        )
    ) {
        RadioButton(
            selected = isSelected, onClick = null, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Gray,
                disabledSelectedColor = Color.Magenta
            )
        )
        Text(text = title, modifier = Modifier.padding(start = 10.dp))
    }
}


@Composable
fun DemoCustomRadioButton(title: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    CustomRadioButton(title = "Female", isSelected = isSelected) { isSelected = !isSelected }
//    Row(
//        modifier = Modifier.selectable(
//            selected = isSelected,
//            onClick = { isSelected = !isSelected },
//            role = Role.RadioButton
//        )
//    ){
//
//        val iconRadio = if (isSelected) Icons.Default.CheckCircle else Icons.Default.Check
//        Icon(iconRadio, contentDescription = null)
//        Text(text = title, modifier = Modifier.padding(start = 10.dp))
//    }
}

//định nghĩa để dùng lại nhiều lần
@Composable
fun CustomRadioButton(title: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = onClick,
            role = Role.RadioButton
        )
    ) {

        val iconRadio = if (isSelected) Icons.Default.CheckCircle else Icons.Default.Check
        Icon(iconRadio, contentDescription = null)
        Text(text = title, modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
fun SimpleButton() {
    val count = remember {
        mutableStateOf(0)
    }
    Text(text = "Click count ${count.value}")
    Button(
        onClick = {
            count.value++
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        )
    ) {
        Icon(Icons.Default.Face, contentDescription = null)
        Text("On Click")

//        Column() {
//            Icon(Icons.Default.Face, contentDescription = null)
//            Text("On Click")
//        }

//        Text("Rigt now", style = TextStyle(color = Color.Yellow))
    }
}

@Composable
fun DisableSimpleButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        enabled = false
    ) {
        Text("Disable Button")
    }
}

@Composable
fun RoundedCornerButton() {
    Button(
        onClick = {},
//        shape = RoundedCornerShape(2.dp)
        shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
    ) {
        Text("Rounede corner Button")
    }
}

@Composable
fun BorderSimpleButton() {
    Button(
        onClick = {},
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text("Checkout", style = TextStyle(color = Color.Cyan))
    }
}

@Composable
fun ElevationSimpleButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
//         hiệu ứng bóng
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text("Text", style = TextStyle(color = Color.Cyan))
    }
}

@Composable
fun DemoClickable() { // Click card, column...
    Column(modifier = Modifier
        .width(100.dp)
        .clickable {

        }) {
        Image(painter = painterResource(id = R.drawable.img_demo), contentDescription = null)
        Text("Product name")
        Text("2005$")
    }
}

@Composable
fun DemoDetectTapestures() { // Ban vao va du lau
    val textContent = remember {
        mutableStateOf("")
    }
    Column {
        Text(text = textContent.value)
        Text(text = "something", modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onDoubleTap = {
                    textContent.value = "double tap"
                },
                onLongPress = {
                    textContent.value = "long press"
                },
                onPress = {
                    textContent.value = "press"
                }
            )
        })
    }
}

@Composable
fun BannerCompose(contentScale: ContentScale) {
    Image(
        painterResource(id = R.drawable.img_demo),
        contentDescription = "Banner image",
        contentScale = contentScale,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .aspectRatio(1f),
        alignment = Alignment.TopCenter
    )
}

@Composable
fun CircleAvatar() {
    Surface(
        modifier = Modifier
            .border(BorderStroke(2.dp, color = Color.Cyan), shape = CircleShape)
            .clip(shape = CircleShape)
    ) {
        Image(
            painterResource(id = R.drawable.cartoon),
            contentDescription = "Cartoon image",
            contentScale = ContentScale.Inside,
        )
    }
}

@Composable
fun UrlImageCompose() {
    Image(
        rememberAsyncImagePainter(model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0mo1-1RPPCSd54lH3fcOeOWM1wRHxEZ3C1A&s"),
        contentDescription = null
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        HomeScreen()
    }
}

