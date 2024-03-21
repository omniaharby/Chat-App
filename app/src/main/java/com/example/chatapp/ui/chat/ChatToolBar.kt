package com.example.chatapp.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.ui.components.CircularImage
import com.example.chatapp.ui.components.bottomShadow

@Composable
fun ChatToolBar(imageUrl: String, name: String, onBackCLick: () -> Unit) {
    Row(
        Modifier
            .height(65.dp)
            .fillMaxWidth()
            .bottomShadow(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = onBackCLick) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
        }
        CircularImage(contentDescription = "", imageUrl = imageUrl)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = name, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowToolbar() {
    ChatToolBar("", "Omnia", {})
}