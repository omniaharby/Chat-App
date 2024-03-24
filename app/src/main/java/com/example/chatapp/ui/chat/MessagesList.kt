package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

    LazyColumn(
        reverseLayout = true,
        modifier = Modifier
            .fillMaxHeight(0.9f).fillMaxWidth(), content = {
            items(data.reversed()) { message ->

                MessageBubble(message, message.id == lastSenderId)
                lastSenderId = message.id
            }
        })
}
