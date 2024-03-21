package com.example.chatapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DateField(
    date: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = date,
        color = textColor,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        modifier = modifier
    )
}