package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.chatapp.datasource.chatList

@Composable
fun ChatScreen(onBackClick: () -> Unit) {

    val chat = chatList[0]
    Column {
        ChatToolBar(chat.imageUrl ?: "", chat.name, onBackClick)
        MessagesList(chat.messages)
    }
}