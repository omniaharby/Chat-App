package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapp.ui.components.InputWithSendIcon

@Composable
fun ChatScreen(onBackClick: () -> Unit, viewModel: ChatViewModel = hiltViewModel()) {

    val chat by viewModel.chat.collectAsState(initial = null)


    chat?.also {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            ChatToolBar(it.imageUrl ?: "", it.name, onBackClick)
            MessagesList(it.messages)
            InputWithSendIcon {

            }
        }
    }?.run {
        // Todo handle empty state
    }

}