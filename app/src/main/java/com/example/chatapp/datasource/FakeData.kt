package com.example.chatapp.datasource

import com.example.chatapp.domain.Chat
import com.example.chatapp.domain.ChatItemData
import com.example.chatapp.domain.Message

fun getChats() = listOf(
    ChatItemData(
        "Omnia",
        "id1",
        "Hello dear how are you?",
        "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0"
    ),
    ChatItemData(
        "Omar",
        "id1",
        "Hello dear how are you?",
        "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0"
    ),
    ChatItemData(
        "Rogi",
        "id1",
        "Hello dear how are you?",
        "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0"
    ),
    ChatItemData(
        "Bodi",
        "id1",
        "Hello dear how are you?",
        "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0" +
                ""
    )
)

val chatList: List<Chat> = listOf(
    Chat(
        name = "John",
        imageUrl = "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0",
        messages = listOf(
            Message("Hello", "2024-03-20 10:00", "id1"),
            Message("Hi there!", "2024-03-20 10:05", "id2"),
            Message(
                "How are you? I heard that your birthday is coming soon happy birthday dear!",
                "2024-03-20 10:10",
                "id1"
            ),
            Message("i sent you a present hope you like it", "2024-03-20 11:05", "id1"),
            Message("oh Thanks that's really kind from you", "2024-03-20 11:15", "id2"),
            Message("so see you next friday?", "2024-03-20 10:05", "id1"),
            Message("yes sure lets meet at the cafe near the beach", "2024-03-20 11:35", "id2"),
            Message("ok then, how is your sister?", "2024-03-20 11:45", "id1"),
            Message("she is getting better, doctors said she will be fine by next week isa.", "2024-03-20 11:46", "id2"),
            Message("great hope she gets well soon", "2024-03-20 11:55", "id1"),
        )
    ),
    Chat(
        name = "Emma",
        imageUrl = "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0",
        messages = listOf(
            Message("Hey", "2024-03-20 11:00", "id3"),
            Message("Morning!", "2024-03-20 11:05", "id1"),
            Message("I'm good, thanks!", "2024-03-20 11:10", "id3")
        )
    ),
    Chat(
        name = "Michael",
        imageUrl = "https://th.bing.com/th/id/R.808636cc55f2ccceac3dab65f59e06a0?rik=rYlKMlOaLmfyUg&pid=ImgRaw&r=0",
        messages = listOf(
            Message("Good evening", "2024-03-20 18:00", "id4"),
            Message("How's it going?", "2024-03-20 18:05", "id1"),
            Message("I'm doing well, thanks!", "2024-03-20 18:10", "id4")
        )
    )
)
