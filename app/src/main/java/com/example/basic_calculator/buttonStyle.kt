package com.example.basic_calculator

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonStyle(text: String="",onclick:()->Unit) {
    Button(onClick={},
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        modifier = Modifier
            .border(2.dp, Color.Blue, RoundedCornerShape(20.dp))

    ) {
        Text(
            text = "$text",
            fontSize = 30.sp,
            style = MaterialTheme.typography.displayLarge,
            color = Color(R.color.number),
            modifier = Modifier
                .size(40.dp),
            textAlign = TextAlign.Center

        )
    }

}