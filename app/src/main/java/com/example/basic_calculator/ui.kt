package com.example.basic_calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorUi() {
    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {//背景黑色 &&填滿畫面


        //案件位置
        Column(verticalArrangement = Arrangement.Bottom) {

            Text(
                text = "123",
                textAlign= TextAlign.End,
                color = Color.White,
                fontSize = 50.sp,
                modifier = Modifier
                    .padding(10.dp, 0.dp)
                    .fillMaxWidth()
                    .height(80.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("%", onclick = {})
                ButtonStyle("CE", onclick = {})
                ButtonStyle("C", onclick = {})
                ButtonStyle("←", onclick = {})
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("⅟x", onclick = {})
                ButtonStyle("x²", onclick = {})
                ButtonStyle("√x", onclick = {})
                ButtonStyle("÷", onclick = {})
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("7", onclick = {})
                ButtonStyle("8", onclick = {})
                ButtonStyle("9", onclick = {})
                ButtonStyle("x", onclick = {})
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("4", onclick = {})
                ButtonStyle("5", onclick = {})
                ButtonStyle("6", onclick = {})
                ButtonStyle("-", onclick = {})
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("1", onclick = {})
                ButtonStyle("2", onclick = {})
                ButtonStyle("3", onclick = {})
                ButtonStyle("+", onclick = {})
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("+/-", onclick = {})
                ButtonStyle("0", onclick = {})
                ButtonStyle(".", onclick = {})
                ButtonStyle("=", onclick = {})
            }
        }
    }
}




