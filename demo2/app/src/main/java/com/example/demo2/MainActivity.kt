package com.example.demo2

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demo2.ui.theme.Demo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demo2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
// state full
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Welcome()

        var email by rememberSaveable {
            mutableStateOf("")
        }

        Email(email){
            email = it
        }

        var passwrod by rememberSaveable {
            mutableStateOf("")
        }
        Password(passwrod = passwrod) {
            passwrod = it
        }

        Button(onClick = {}) {
            Text(text = "Login")
        }
    }
}

@Composable
//state less
fun Email(email: String, onEmailChange: (String) -> Unit){
    OutlinedTextField(value = email, onValueChange = onEmailChange)
}

@Composable
fun Password(passwrod: String, onPasswordChange: (String) -> Unit){
    OutlinedTextField(value = passwrod, onValueChange = onPasswordChange)
}

@Composable
fun Welcome(){
    Text(text = "Login")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Demo2Theme {
        LoginScreen()
    }
}