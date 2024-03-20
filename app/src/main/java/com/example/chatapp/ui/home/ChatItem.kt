package com.example.chatapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatapp.domain.ChatItemData
import com.example.chatapp.ui.components.CircularImage

@Composable
fun ChatItem(data: ChatItemData) {
    Row {
        CircularImage(imageUrl =data.imageUrl , contentDescription = "")
        Column {
            Text(text = "Name")
            Text(text = "description")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCHatItem() {
    ChatItem(
        data =
        ChatItemData(
            "Omnia",
            "id1",
            "bla bla bla ",
            "https://image.shutterstock.com/image-photo/cute-avatar-3d-image-bright-260nw-2402123373.jpg",
        )
    )
}