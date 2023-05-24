package com.example.basic_calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun calculatorUi(){
    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {//背景黑色 &&填滿畫面
        val context = LocalContext.current
        val width = context.resources.configuration.screenWidthDp
        val requireSize = width / 4

        Column {
            Row(Modifier.fillMaxWidth()) {
                ButtonStyle("1",requireSize=requireSize, onclick = {})
                ButtonStyle("2",requireSize=requireSize, onclick = {})
                ButtonStyle("3",requireSize=requireSize, onclick = {})
                ButtonStyle("=",requireSize=requireSize, onclick = {})
            }
        }
    }


}