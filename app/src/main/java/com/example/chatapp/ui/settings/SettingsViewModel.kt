package com.example.chatapp.ui.settings

import androidx.lifecycle.ViewModel
import com.example.chatapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    suspend fun updateUserName(name: String) {
        repository.updateUserName(name)
    }

    suspend fun updateUserBio(bio: String) {
        repository.updateUserBio(bio)
    }

    suspend fun updateUserPhoneNumber(phone: String) {
        repository.updateUserPhone(phone)
    }
}