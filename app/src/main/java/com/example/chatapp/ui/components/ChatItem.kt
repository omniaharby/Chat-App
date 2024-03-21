package com.example.chatapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.domain.ChatItemData

@Composable
fun ChatItem(data: ChatItemData, onClickAction: (String) -> Unit) {
    Row(
        Modifier
            .clickable { onClickAction(data.id) }
            .fillMaxWidth()
            .padding(16.dp, 12.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        CircularImage(imageUrl = data.imageUrl, contentDescription = "")
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = data.name,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = data.thumbnail, style = TextStyle(fontSize = 20.sp))
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
        ), {}
    )
}