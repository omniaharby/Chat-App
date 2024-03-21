package com.example.chatapp.ui.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

fun Modifier.bottomShadow(): Modifier = drawBehind {
    val shadowHeight = 2.dp.toPx()
    val shadowColor = Color.Black.copy(alpha = 0.2f)

    val path = Path().apply {
        moveTo(0f, size.height)
        lineTo(size.width, size.height)
        lineTo(size.width, size.height - shadowHeight)
        lineTo(0f, size.height - shadowHeight)
        close()
    }

    drawPath(path, color = shadowColor)
}