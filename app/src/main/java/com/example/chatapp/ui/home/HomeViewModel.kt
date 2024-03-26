package com.example.chatapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.domain.ChatItemData
import com.example.chatapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _chatList = MutableStateFlow<List<ChatItemData>?>(null)
    val chatList get() = _chatList.filterNotNull()

    init {
        updateChatListFlow()
    }

    private fun updateChatListFlow() {
        viewModelScope.launch {
            _chatList.value = getChatListFlow().first()
        }
    }

    suspend fun getChatListFlow(): Flow<List<ChatItemData>> {
        return repository.getAllChats()
    }
}