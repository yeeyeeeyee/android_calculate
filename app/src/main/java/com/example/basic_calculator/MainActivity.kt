package com.example.basic_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basic_calculator.ui.theme.Basic_CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Basic_CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
@Composable
fun a (){
    Row(Modifier.fillMaxWidth()) {
        Text(text = "Hello", modifier = Modifier.weight(1f))
        Text(text = "World", modifier = Modifier.weight(1f))
        Text(text = "Compose", modifier = Modifier.weight(1f))
    }

}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    Basic_CalculatorTheme {
        //calculatorUi()

    }
}