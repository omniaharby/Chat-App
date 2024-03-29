package com.example.chatapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapp.datasource.getChats
import com.example.chatapp.ui.components.ChatsList
import com.example.chatapp.ui.components.ToolBar

@Composable
fun HomeScreen(
    onChatClick: (String) -> Unit,
    goToSettings: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val chats by viewModel.chatList.collectAsState(initial = null)

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {/*Todo*/ },
                content = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "search",
                        modifier = Modifier
                            .size(25.dp)
                    )
                })
        }
    ) {

        Column(modifier = Modifier.padding(it)) {
            ToolBar({}, goToSettings)
            chats?.also {
                ChatsList(data = getChats(), onChatClick)
            }?.run {
                // Todo handle empty state
            }
        }
    }

}