package com.example.app2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app2.ui.theme.App2Theme
import com.example.app2.ui.theme.CalculatorApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2Theme {
                // A surface container using the 'background' color from the theme
                startActivity(Intent(applicationContext,CalculatorApp::class.java))
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(applicationContext)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(applicationContext: Context) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var text2 by remember { mutableStateOf(TextFieldValue("")) }
    var flag by remember { mutableStateOf(false) }
    var flag2 by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        /*
            Text(text = "UserName",
            fontSize = 32.sp,
            color = Color.Green)
        Text(text = "Password",
            fontSize = 32.sp,
            color = Color.Green
        )
         */
        TextField(value = text,
            onValueChange = {
                text= it
            },
            label = { Text(text = "Name")})
        TextField(value = text2,
            onValueChange = {
                text2 = it
            },
            label = { Text(text = "Email")})
        Row(modifier = Modifier.padding(top = 20.dp)
            ) {
                Button(onClick = {
                    Toast.makeText(applicationContext,"Sign Up pressed",Toast.LENGTH_SHORT).show()
                    flag = true
                }) {
                    Text(text = "Sign Up")
                }
                Button(onClick = {
                    Toast.makeText(applicationContext,"Sign In pressed",Toast.LENGTH_SHORT).show()
                    flag2= true
                }) {
                    Text(text = "Sign In")
                }
        }
        if(flag){
            Text(text = "${text.text}",
                color = Color.Black,
                fontSize = 24.sp)
        }
        if(flag2){
            Text(text = "${text2.text}",
                color = Color.Black,
                fontSize = 24.sp)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App2Theme {
        Greeting(LocalContext.current)
    }
}