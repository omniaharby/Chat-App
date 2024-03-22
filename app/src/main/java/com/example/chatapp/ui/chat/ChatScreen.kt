package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapp.datasource.chatList

@Composable
fun ChatScreen(onBackClick: () -> Unit, viewModel: ChatViewModel = hiltViewModel()) {

    val chat = chatList[0]
    Column {
        ChatToolBar(chat.imageUrl ?: "", chat.name, onBackClick)
        MessagesList(chat.messages)
    }
}