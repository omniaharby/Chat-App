package com.example.chatapp.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapp.repository.UserRepository
import com.example.chatapp.ui.components.CircularImage

@Composable
fun SettingsScreen(onBackClick: () -> Unit, viewModel: SettingsViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SettingsToolBar(onBackClick)
        Spacer(modifier = Modifier.height(36.dp))
        Box {
            CircularImage(
                contentDescription = "Profile Image",
                imageSize = 150.dp,
            )
            FloatingActionButton(
                shape = RoundedCornerShape(25.dp),
                containerColor = Color.Blue,
                onClick = {
                    // handle action
                },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(48.dp)
                    .align(Alignment.BottomEnd),
                content = {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Upload new image",
                        tint = Color.White
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Column {
            SettingsItem(
                icon = Icons.Rounded.Person,
                text = "Name",
                details = "Your name here",
            )
            SettingsItem(
                icon = Icons.Outlined.Info,
                text = "About",
                details = "About yourself",
            )
            SettingsItem(
                icon = Icons.Filled.Phone,
                text = "Phone Number",
                details = "Your phone number",
            )
        }
    }
}

@Preview
@Composable
fun SHowSettings() {
    SettingsScreen(
        { },
        SettingsViewModel(UserRepository())
    )
}

@Preview
@Composable
fun SHowItem() {
    SettingsItem(
        icon = Icons.Filled.Phone,
        text = "Phone",
        details = "This IS the phone number linked to this account",
    )
}