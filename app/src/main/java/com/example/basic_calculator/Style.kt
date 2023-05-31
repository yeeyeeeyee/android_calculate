package com.example.basic_calculator

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
//按鈕樣式
fun ButtonStyle(
    text: String="",
    color: Color= colorResource(id=R.color.number),
    onclick:()->Unit,
) {
    Button(
        onClick=onclick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        modifier = Modifier
            .border(2.dp, Color.Blue, RoundedCornerShape(20.dp))

    ) {
        Text(
            text = text,
            fontSize = 30.sp,
            style = MaterialTheme.typography.displayLarge,
            color = color,
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
        color = Color.Gray,
        fontSize = 30.sp,
    )
}
