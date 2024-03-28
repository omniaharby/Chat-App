package com.example.chatapp.repository

import android.graphics.Bitmap
import javax.inject.Inject

class UserRepository @Inject constructor() {

    suspend fun registerWithPhoneNumber(phone: String) {
        //TODO("implement Register with phone number )
    }

    suspend fun checkPin(pin: Int): String {
        //TODO("Implement check pin")
        return ""
    }

    suspend fun updateUserName(name: String): Boolean {
        TODO("Implement update username ")
    }

    suspend fun updateUserBio(name: String): Boolean {
        TODO("Implement update bio")
    }

    suspend fun updateUserPhoto(name: Bitmap): Boolean {
        TODO("Implement update user phone number")
    }

    suspend fun updateUserPhone(name: String): Boolean {
        TODO("Implement update user phone number")
    }
}