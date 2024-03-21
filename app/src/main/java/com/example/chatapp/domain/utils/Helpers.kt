package com.example.chatapp.domain.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.chatapp.domain.User
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.Locale


fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
    return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
}

fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
    return stream.toByteArray()
}


fun formatTime(timestamp: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    val outputFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
    val date = inputFormat.parse(timestamp) ?: return ""

    return outputFormat.format(date)
}

fun getUser(): User = User(id = "id1", name = "Omnia")