package com.example.chatapp.domain

import android.graphics.Bitmap

data class ChatItemData(
    val name: String,
    val id: String,
    val thumbnail: String,
    val imageUrl: String? = null,
    val imageBitMap: Bitmap? = null
)

data class Message(
    val message: String,
    val date: String,
    val id: String
)

data class Chat(
    val name: String,
    val imageUrl: String? = null,
    val imageBitMap: Bitmap? = null,
    val messages: List<Message>
)

data class User(
    val name:String,
    val id:String,
)

