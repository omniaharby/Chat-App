package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapp.datasource.chatList
import com.example.chatapp.ui.components.InputWithSendIcon

@Composable
fun ChatScreen(onBackClick: () -> Unit, viewModel: ChatViewModel = hiltViewModel()) {

    val chat = chatList[0]
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        ChatToolBar(chat.imageUrl ?: "", chat.name, onBackClick)
        MessagesList(chat.messages)
        InputWithSendIcon {

        }
    }
}