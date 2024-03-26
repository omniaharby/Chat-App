package com.example.chatapp.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.chatapp.ui.components.bottomShadow

@Composable
fun SettingsToolBar(onBackCLick: () -> Unit) {
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
        Text(text = "Settings", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowToolbar() {
    SettingsToolBar({})
}