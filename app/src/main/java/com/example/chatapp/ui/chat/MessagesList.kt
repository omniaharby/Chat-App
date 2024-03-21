package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.chatapp.domain.Message

@Composable
fun MessagesList(data: List<Message>) {
    var lastSenderId by remember {
        mutableStateOf("")
    }

    LazyColumn(Modifier.fillMaxSize(), content = {
        items(data) { message ->

            MessageBubble(message, message.id == lastSenderId)
            lastSenderId = message.id
        }
    })
}
