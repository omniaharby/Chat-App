package com.example.chatapp.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.domain.Message
import com.example.chatapp.domain.utils.formatTime
import com.example.chatapp.domain.utils.getUser
import com.example.chatapp.ui.components.DateField

@Composable
fun MessageBubble(
    message: Message,
    isSameSender: Boolean = false
) {
    val alignment = remember { getMessageAlignment(message) }
    val backgroundColor = getBackgroundColor(alignment)
    val textColor = getTextColor(alignment)
    val cornerShape = getCornerShape(alignment, isSameSender)
    val paddingValues = PaddingValues(8.dp, if (isSameSender) 0.dp else 8.dp, 8.dp, 4.dp)

    Row(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        horizontalArrangement = getHorizontalArrangement(alignment)
    ) {
        if (message.message.length >= 30) {
            LongMessage(
                cornerShape,
                backgroundColor,
                message.message,
                message.date,
                textColor
            )
        } else {
            ShortMessage(
                cornerShape,
                backgroundColor,
                message.message,
                message.date,
                textColor
            )
        }
    }
}

@Composable
fun LongMessage(
    cornerShape: Shape,
    backgroundColor: Color,
    message: String,
    date: String,
    textColor: Color
) {
    Column(
        modifier = Modifier
            .clip(cornerShape)
            .background(backgroundColor)
            .fillMaxWidth(0.7f)
            .padding(8.dp),
        horizontalAlignment = Alignment.End
    ) {
        MessageField(text = message, textColor)
        DateField(date = formatTime(date), textColor)
    }
}

@Composable
fun ShortMessage(
    cornerShape: Shape,
    backgroundColor: Color,
    message: String,
    date: String,
    textColor: Color
) {
    Row(
        modifier = Modifier
            .clip(cornerShape)
            .background(backgroundColor)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MessageField(text = message, textColor)
        DateField(date = formatTime(date), textColor)
    }
}

@Composable
fun MessageField(text: String, textColor: Color) {
    Text(
        text = text,
        color = textColor,
        fontSize = 16.sp,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

fun getCornerShape(
    alignment: MessageAlignment,
    isSameSender: Boolean
): Shape {
    return if (isSameSender) RoundedCornerShape(16.dp)
    else getCornerShape(alignment)
}

private fun getMessageAlignment(message: Message): MessageAlignment {
    return if (message.id == getUser().id) MessageAlignment.SENT else MessageAlignment.RECEIVED
}

private fun getBackgroundColor(alignment: MessageAlignment): Color {
    return if (alignment == MessageAlignment.RECEIVED) Color.LightGray else Color.Blue
}

private fun getTextColor(alignment: MessageAlignment): Color {
    return if (alignment == MessageAlignment.RECEIVED) Color.Black else Color.White
}

private fun getCornerShape(alignment: MessageAlignment): Shape {
    return when (alignment) {
        MessageAlignment.RECEIVED -> RoundedCornerShape(

            topEnd = 16.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        )

        MessageAlignment.SENT -> RoundedCornerShape(
            topStart = 16.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        )
    }
}

private fun getHorizontalArrangement(alignment: MessageAlignment): Arrangement.Horizontal {
    return if (alignment == MessageAlignment.RECEIVED) Arrangement.Start else Arrangement.End
}

enum class MessageAlignment {
    SENT, RECEIVED
}