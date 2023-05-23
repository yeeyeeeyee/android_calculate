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
fun calculatorUi(){
    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {//背景黑色 &&填滿畫面
        Column {
            Row(Modifier.fillMaxWidth()) {
                ButtonStyle("1") {}
                ButtonStyle("2") {}
                ButtonStyle("3") {}
                ButtonStyle("=") {}
            }
        }
    }


}