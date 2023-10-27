package com.example.basic_calculator

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UiStyle(
    private var buttonColor: Color = Color.Red,
    private var textColors: Color = Color.Black,
    private var displayTextColor:Color=Color.Black,
    private var borderColor:Color=Color.Red,

    ){
    //暫存顏色
    init {
        buttonColor = Color(0xffC5C9BA)
        textColors = Color(0xff4A514D)
        displayTextColor = Color(0xff4A514D)
        borderColor = Color(0xff889275)

    }

    @Composable
    //按鈕樣式
    fun ButtonStyle(
        text: String="",
        onclick:()->Unit,
    ) {
        Button(
            onClick=onclick,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            modifier = Modifier
                .border(2.dp, borderColor, RoundedCornerShape(20.dp))

        ) {
            Text(
                text = text,
                fontSize = 30.sp,
                style = MaterialTheme.typography.displayLarge,
                color = Color.Black,
                modifier = Modifier
                    .size(40.dp),
                textAlign = TextAlign.Center
            )
        }

    }
    @Composable
    //顯示文字樣式
    fun DisplayText(text: String) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Clip,
            modifier = Modifier
                .fillMaxWidth(),
            color = displayTextColor,
            fontSize = 30.sp,
        )
    }

    @Composable
    fun Text(display:String){
        //顯示輸入文字樣式
        Text(
            text = display,
            textAlign = TextAlign.End,
            color = textColors,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .fillMaxWidth()
                .height(80.dp)
        )
    }


}
