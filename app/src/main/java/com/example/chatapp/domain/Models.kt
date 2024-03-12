package com.example.chatapp.domain

import android.media.Image

data class ChatItem(val name: String, val id: String, val thumbnail: String, val image: Image)

data class Message(val message: String, val date: String)

data class Chat(val name: String, val image: Image, val messages: List<Message>)

