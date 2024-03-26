package com.example.chatapp.ui.chat

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.domain.Chat
import com.example.chatapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: Repository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val chatId: String? = savedStateHandle.get<String>(KEY_ID)

    private val _chat = MutableStateFlow<Chat?>(null)
    val chat: Flow<Chat> get() = _chat.filterNotNull()

    init {
        chatId?.also {
            updateChatFlow(chatId)
        }
    }

    private fun updateChatFlow(id: String) {
        viewModelScope.launch {
            _chat.value = getChatById(id).catch { /*handle error here */ }.first()
        }
    }

    private suspend fun getChatById(id: String): Flow<Chat> {
        return repository.getChatById(id)
    }

}

const val KEY_ID = "id"