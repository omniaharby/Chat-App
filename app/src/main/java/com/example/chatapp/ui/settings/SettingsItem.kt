package com.example.chatapp.ui.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SettingsItem(
    icon: ImageVector,
    text: String,
    details: String,
    onEditClick: (() -> Unit)? = null,
    onChangeTextAction: (String) -> Unit = { _ -> }
) {
    var isEditModeOn by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        EditableTextViewWithDetails(isEditModeOn, text, details, onChangeTextAction)

        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { onEditClick?.invoke() ?: run { isEditModeOn = !isEditModeOn } }) {
            Icon(
                imageVector = if (isEditModeOn) Icons.Filled.Done else Icons.Filled.Edit,
                contentDescription = "Edit"
            )
        }
    }
}

@Composable
fun EditableTextViewWithDetails(
    isEditModeOn: Boolean,
    text: String,
    details: String,
    onChangeTextAction: (String) -> Unit
) {

    if (isEditModeOn) {
        val focusRequester = remember { FocusRequester() }
        LaunchedEffect(key1 = isEditModeOn) {
            focusRequester.requestFocus()
        }

        TextField(
            value = text,
            onValueChange = onChangeTextAction,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .focusRequester(focusRequester),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            placeholder = { Text("Enter your message...") }
        )
    } else {
        Column(Modifier.padding(vertical = 6.5.dp)) {
            Text(text = text, color = Color.Black)
            Text(text = details, Modifier.fillMaxWidth(0.7f), color = Color.Gray)
        }
    }
}
