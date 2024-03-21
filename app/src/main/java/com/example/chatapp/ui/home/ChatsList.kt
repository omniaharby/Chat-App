package com.example.chatapp.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.chatapp.domain.ChatItemData

@Composable
fun ChatsList(data: List<ChatItemData>, onItemClick: (String) -> Unit) {

    LazyColumn(content = {
        items(data) { chatItem ->

            ChatItem(chatItem, onItemClick)
        }
    })
}