package com.example.basic_calculator

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ButtonStyle(text: String="",onclick:()->Unit) {
    Surface(
        color = Color.Black,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.border(2.dp, Color.Blue, RoundedCornerShape(20.dp))
    ) {
        Text(
            text = "$text",
            style = MaterialTheme.typography.displayLarge,
            color = Color(0xFF135BE8),
            modifier = Modifier
                .size(165.dp, 123.dp)
                .padding(16.dp), textAlign = TextAlign.Center

        )
    }

}