package com.example.chatapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputWithSendIcon(
    sendIcon: ImageVector = Icons.Filled.Send,
    onSendClicked: (String) -> Unit
) {
    var text by remember { mutableStateOf(TextFieldValue()) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Input text field with round corners
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f).shadow(4.dp,RoundedCornerShape(25.dp),false),
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = { Text("Enter your message...") }
            )

            // Send button with round shape
            FloatingActionButton(
                shape = RoundedCornerShape(25.dp),
                containerColor = Color.Blue,
                onClick = {
                    if (text.text.isNotBlank()) {
                        onSendClicked(text.text)
                        text = TextFieldValue()
                    }
                },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(48.dp),
                content = {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        imageVector = sendIcon,
                        contentDescription = "Send",
                        tint = Color.White
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowInputText() {
    InputWithSendIcon {

    }
}