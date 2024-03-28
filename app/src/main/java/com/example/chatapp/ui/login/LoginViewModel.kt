package com.example.chatapp.ui.login

import androidx.lifecycle.ViewModel
import com.example.chatapp.domain.ChatItemData
import com.example.chatapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    suspend fun registerWithPhoneNumber(phone: String) {
        repository.registerWithPhoneNumber(phone)
    }

    suspend fun checkPin(pin: Int) {
        repository.checkPin(pin)
    }
}