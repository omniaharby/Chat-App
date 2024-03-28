package com.example.chatapp.repository

import com.example.chatapp.datasource.chatList
import com.example.chatapp.datasource.getChats
import com.example.chatapp.domain.Chat
import com.example.chatapp.domain.ChatItemData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChatRepository @Inject constructor() {

    suspend fun getAllChats(): Flow<List<ChatItemData>> {
        return flow {
            for (i in 1..10) {
                delay(100) // Simulate some delay
                emit(getChats())
            }
        }
    }

    suspend fun getChatById(id: String): Flow<Chat> {
        return flow {
            for (i in 1..10) {
                delay(100) // Simulate some delay
                emit(chatList[id.toInt()-1])
            }
        }
    }
}