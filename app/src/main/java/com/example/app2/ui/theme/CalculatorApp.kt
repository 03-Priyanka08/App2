package com.example.app2.ui.theme

import android.content.Context
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app2.R
import com.example.app2.ui.theme.ui.theme.App2Theme
import kotlin.math.abs

class CalculatorApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2(applicationContext)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2(applicationContext: Context) {
    var a by remember { mutableStateOf(TextFieldValue("")) }
    var b by remember { mutableStateOf(TextFieldValue("")) }
    var c by remember { mutableStateOf(0.000) }
    var f1 by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .paint(painter = painterResource(id = R.drawable.bgimg)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        TextField(value = a,
            onValueChange = {
                a= it
            },
            label = { Text(text = "1st No.")})
        TextField(value = b,
            onValueChange = {
                b = it
            },
            label = { Text(text = "2nd No.")})
        Row(modifier = Modifier.padding(top = 20.dp)
        ) {
            Button(onClick = {
                c = (a.text.toDouble() +b.text.toDouble())
                Toast.makeText(applicationContext,"Added", Toast.LENGTH_SHORT).show()
                f1 = true
            }) {
                Text(text = "Add")
            }
            Button(onClick = {
                c = (abs(a.text.toDouble()-b.text.toDouble()))
                Toast.makeText(applicationContext,"Substracted", Toast.LENGTH_SHORT).show()
                f1 = true
            }) {
                Text(text = "Subs")
            }
            Button(onClick = {
                c = (a.text.toDouble()*b.text.toDouble())
                Toast.makeText(applicationContext,"Multiply", Toast.LENGTH_SHORT).show()
                f1=true
            }) {
                Text(text = "Multi")
            }
            Button(onClick = {
                if(b.text != "0")
                    c = (a.text.toDouble()/b.text.toDouble())
                else
                    c = -1.000
                Toast.makeText(applicationContext,"Divide", Toast.LENGTH_SHORT).show()
                f1= true
            }) {
                Text(text = "Div")
            }
        }
        if(f1){
            Text(text = "$c",
                color = Color.Black,
                fontSize = 24.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    App2Theme {
        Greeting2(LocalContext.current)
    }
}