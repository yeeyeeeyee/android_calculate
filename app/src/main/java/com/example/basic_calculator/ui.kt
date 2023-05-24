package com.example.basic_calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CalculatorUi(){
    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {//背景黑色 &&填滿畫面

        Column {
            Row(Modifier.fillMaxWidth()) {
                ButtonStyle("1", onclick = {})
                ButtonStyle("2", onclick = {})
                ButtonStyle("3", onclick = {})
                ButtonStyle("=", onclick = {})
            }
        }
    }


}