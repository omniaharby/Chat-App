package com.example.chatapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolBar(onSearchQueryChange: (String) -> Unit, goToSettings: () -> Unit) {
    Row(
        Modifier
            .height(65.dp)
            .fillMaxWidth()
            .bottomShadow()
            .padding(16.dp)
            .background(Color.White), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Chats", style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold))
        Row {
            SearchView(query = "", onSearchQueryChange)
            IconButton(onClick = goToSettings) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "go to settings",
                    tint = Color.DarkGray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowToolbar() {
    ToolBar({}, {})
}