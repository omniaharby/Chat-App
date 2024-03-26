package com.example.chatapp.ui.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapp.ui.components.CircularImage

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SettingsToolBar {
            // todo go back
        }
        Spacer(modifier = Modifier.height(36.dp))

        CircularImage(contentDescription = "Profile Image", imageSize = 150.dp)

        Spacer(modifier = Modifier.height(26.dp))

        Column {
            SettingsItem(
                icon = Icons.Rounded.Person,
                text = "Name",
                explanation = "Your name here",
                onEditClick = {}
            )
            SettingsItem(
                icon = Icons.Outlined.Info,
                text = "About",
                explanation = "About yourself",
                onEditClick = {}
            )
            SettingsItem(
                icon = Icons.Filled.Phone,
                text = "Phone Number",
                explanation = "Your phone number",
                onEditClick = {}
            )
        }
    }
}

@Composable
fun SettingsItem(
    icon: ImageVector,
    text: String,
    explanation: String,
    onEditClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = text, color = Color.Black)
            Text(text = explanation, color = Color.Gray)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onEditClick) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit"
            )
        }
    }
}